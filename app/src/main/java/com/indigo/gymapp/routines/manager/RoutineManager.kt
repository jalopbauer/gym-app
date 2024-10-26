package com.indigo.gymapp.routines.manager

import androidx.lifecycle.asFlow
import com.indigo.gymapp.database.GymDatabase
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.RoutineExerciseBuilder
import com.indigo.gymapp.domain.routines.exercises.SetExercise
import com.indigo.gymapp.domain.routines.exercises.TimedExercise
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.exercises.Exercise
import com.indigo.gymapp.routines.RoutineEntity
import com.indigo.gymapp.routines.exercises.SetExerciseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoutineManager @Inject constructor(gymDatabase: GymDatabase) : RoutineHandler {

    private var routineManagerState : RoutineManagerState = CreateRoutine
    private var routineExerciseState : RoutineExerciseState = CreateRoutineExercise

    private val initialRoutineName = ""
    private val initialRoutineRestTimeBetweenExercises = Rest(2, 0)
    private val initialRoutineExercises = listOf<RoutineExercise>()

    private var _name = MutableStateFlow(initialRoutineName)

    val name = _name.asStateFlow()
    private var _restTimeBetweenExercises = MutableStateFlow(initialRoutineRestTimeBetweenExercises)
    val restTimeBetweenExercises = _restTimeBetweenExercises.asStateFlow()

    override suspend fun setRestTimeBetweenExercises(newRest: Rest) {
        when (val typedRoutineManagerState = routineManagerState) {
            CreateRoutine -> _restTimeBetweenExercises.value = newRest
            is EditRoutine -> {
                _restTimeBetweenExercises.value = newRest
                routinesDao.update(typedRoutineManagerState.routineEntity.copy(rest = newRest))
            }
        }
    }

    override suspend fun changeRoutineName(newRoutineName: String) {
        when (val typedRoutineManagerState = routineManagerState) {
            CreateRoutine -> _name.value = newRoutineName
            is EditRoutine -> {
                _name.value = newRoutineName
                routinesDao.update(typedRoutineManagerState.routineEntity.copy(name = newRoutineName))
            }
        }
    }

    private var _routineExercises = MutableStateFlow(initialRoutineExercises)
    val exercises = _routineExercises.asStateFlow()

    override suspend fun addExercise(routineExercise: RoutineExercise) {
        when (val typedRoutineManagerState = routineManagerState) {
            CreateRoutine -> {
                when (val typedRoutineExerciseState = routineExerciseState) {
                    CreateRoutineExercise -> {
                        val newList = _routineExercises.value + routineExercise.setId(_routineExercises.value.size.toLong())
                        setRoutineExercises(newList)
                    }
                    is EditRoutineExercise -> {

                    }
                }

            }
            is EditRoutine -> {
                when (val typedRoutineExerciseState = routineExerciseState) {
                    CreateRoutineExercise -> {
                        when (routineExercise) {
                            is SetExercise -> {
                                val setExerciseEntity = fromRoutineExerciseToEntity(
                                    typedRoutineManagerState.routineEntity.id,
                                    _routineExercises.value.size,
                                    routineExercise
                                )
                                val id = setExerciseDao.create(setExerciseEntity)
                                val newList = _routineExercises.value + routineExercise.setId(id)
                                setRoutineExercises(newList)
                            }
                            is TimedExercise -> {}
                        }
                    }
                    is EditRoutineExercise -> {

                    }
                }
            }
        }

    }

    private val initialRoutineExerciseBuilder = RoutineExerciseBuilder(
        rest = Rest(2, 0),
        amountOfSets = 4
    )

    private var _routineExerciseBuilder = MutableStateFlow(
        initialRoutineExerciseBuilder
    )
    val routineExerciseBuilder = _routineExerciseBuilder.asStateFlow()

    override fun setRoutineExerciseBuilder(routineExerciseBuilder: RoutineExerciseBuilder) {
        this._routineExerciseBuilder.value = routineExerciseBuilder
    }

    override fun setRoutineExerciseBuilderRest(newRest: Rest) {
        _routineExerciseBuilder.value = _routineExerciseBuilder.value.copy(rest = newRest)
    }

    override fun setRoutineExerciseBuilderExercise(exercise: Exercise) {
        _routineExerciseBuilder.value = _routineExerciseBuilder.value.copy(exercise = exercise)
    }

    override fun setRoutineExerciseBuilderAmountOfSets(amountOfSets: Int) {
        _routineExerciseBuilder.value = _routineExerciseBuilder.value.copy(amountOfSets = amountOfSets)

    }

    override fun setInitialRoutineExerciseBuilder() {
        _routineExerciseBuilder.value = initialRoutineExerciseBuilder
    }

    private val routinesDao = gymDatabase.routinesDao()
    private val setExerciseDao = gymDatabase.setExerciseDao()

    val routines = routinesDao.getAll().asFlow()

    override suspend fun saveRoutine(): SaveRoutineResult =
        when {
            name.value == initialRoutineName -> MissingName
            else -> {
                withContext(Dispatchers.Default) {
                    when (routineManagerState) {
                        CreateRoutine -> saveNewRoutine()
                        is EditRoutine -> {}
                    }
                }
                Saved
            }
        }

    private suspend fun saveNewRoutine() {
        val createdRoutineEntityId = routinesDao.create(
            RoutineEntity(
                name = name.value,
                rest = restTimeBetweenExercises.value
            )
        )
        val setExerciseEntities = exercises.value
            .filterIsInstance<SetExercise>()
            .mapIndexed { index, routineExercise ->
                fromRoutineExerciseToEntity(createdRoutineEntityId, index, routineExercise)
            }
        setExerciseDao.insertAll(setExerciseEntities)
    }

    private fun fromRoutineExerciseToEntity(
        routineId: Long,
        order: Int,
        routineExercise: SetExercise
    ) = SetExerciseEntity(
        routineId = routineId,
        order = order,
        exerciseId = routineExercise.exercise.id,
        amountOfSets = routineExercise.amountOfSets,
        rest = routineExercise.rest
    )

    override suspend fun setRoutineId(routineId: Long): SetRoutineResult =
        withContext(Dispatchers.Default) {
            routinesDao.findById(routineId)?.let { routine ->
                routineManagerState = EditRoutine(routine)
                changeRoutineName(routine.name)
                setRestTimeBetweenExercises(routine.rest)
                val routineSetExercises = setExerciseDao.getAllByRoutineIdWithExercise(routine.id).map {
                    SetExercise(
                        id = it.id,
                        exercise = Exercise(
                            id = it.exerciseId,
                            name = it.exerciseName
                        ),
                        amountOfSets = it.amountOfSets,
                        rest = it.rest
                    )
                }
                setRoutineExercises(routineSetExercises)
                RoutineFound
            } ?: RoutineNotFound
        }

    override suspend fun setInitialRoutine() {
        routineManagerState = CreateRoutine
        changeRoutineName(initialRoutineName)
        setRestTimeBetweenExercises(initialRoutineRestTimeBetweenExercises)
        setRoutineExercises(initialRoutineExercises)
        setInitialRoutineExerciseBuilder()
    }

    override suspend fun deleteRoutine(routineId: Long) {
        withContext(Dispatchers.Default) {
            routinesDao.findById(routineId)?.let { routine ->
                setExerciseDao.deleteByRoutineId(routine.id)
                routinesDao.delete(routine)
            }
        }
    }

    override suspend fun deleteRoutineExercise(routineExerciseId: Long) {
        withContext(Dispatchers.Default) {
            when (val typedRoutineManagerState = routineManagerState) {
                CreateRoutine -> {
                    val newRoutineExercises =
                        _routineExercises.value.filterNot { it.id == routineExerciseId }
                            .mapIndexed { index, routineExercise ->
                                routineExercise.setId(index.toLong())
                            }
                    setRoutineExercises(newRoutineExercises)
                }
                is EditRoutine -> {
                    setExerciseDao.deleteById(routineExerciseId)
                    val routineSetExercises = setExerciseDao.getAllByRoutineIdWithExercise(typedRoutineManagerState.routineEntity.id).map {
                        SetExercise(
                            id = it.id,
                            exercise = Exercise(
                                id = it.exerciseId,
                                name = it.exerciseName
                            ),
                            amountOfSets = it.amountOfSets,
                            rest = it.rest
                        )
                    }
                    setRoutineExercises(routineSetExercises)
                }
            }
        }
    }

    private suspend fun setRoutineExercises(newList: List<RoutineExercise>) {
        withContext(Dispatchers.Default) {
            _routineExercises.emit(newList)
        }
    }

}


