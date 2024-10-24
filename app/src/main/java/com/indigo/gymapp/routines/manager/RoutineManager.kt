package com.indigo.gymapp.routines.manager

import androidx.lifecycle.asFlow
import com.indigo.gymapp.database.GymDatabase
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.RoutineExerciseBuilder
import com.indigo.gymapp.domain.routines.exercises.SetExercise
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
class RoutineManager @Inject constructor(private val gymDatabase: GymDatabase) : RoutineHandler {

    private var routineManagerState : RoutineManagerState = CreateRoutine

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
        val newList = _routineExercises.value + routineExercise.setId(_routineExercises.value.size.toLong())
        setRoutineExercises(newList)
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
                SetExerciseEntity(
                    routineId = createdRoutineEntityId,
                    order = index,
                    exerciseId = routineExercise.exercise.id,
                    amountOfSets = routineExercise.amountOfSets,
                    rest = routineExercise.rest
                )
            }
        setExerciseDao.insertAll(setExerciseEntities)
    }

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

    private suspend fun setRoutineExercises(newList: List<RoutineExercise>) {
        withContext(Dispatchers.Default) {
            _routineExercises.emit(newList)
        }
    }

}


