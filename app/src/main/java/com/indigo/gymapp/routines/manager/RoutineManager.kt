package com.indigo.gymapp.routines.manager

import androidx.annotation.IntRange
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
    private val initialRoutineName = ""
    private val initialRoutineRestTimeBetweenExercises = Rest(2, 0)
    private val initialRoutineExercises = listOf<RoutineExercise>()

    private var _name = MutableStateFlow(initialRoutineName)

    val name = _name.asStateFlow()
    private var _restTimeBetweenExercises = MutableStateFlow(initialRoutineRestTimeBetweenExercises)
    val restTimeBetweenExercises = _restTimeBetweenExercises.asStateFlow()

    override fun setRestTimeBetweenExercisesSeconds(@IntRange(from = 0, to = 59) seconds: Int) {
        _restTimeBetweenExercises.value = _restTimeBetweenExercises.value.copy(seconds = seconds)
    }

    override fun setRestTimeBetweenExercisesMinutes(@IntRange(from = 0, to = 59) minutes: Int) {
        _restTimeBetweenExercises.value = _restTimeBetweenExercises.value.copy(minutes = minutes)
    }

    override fun changeRoutineName(newRoutineName: String) {
        _name.value = newRoutineName
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

    override fun setRoutineExerciseBuilderRestMinutes(minutes: Int) {
        _routineExerciseBuilder.value = _routineExerciseBuilder.value.copy(rest = _routineExerciseBuilder.value.rest.copy(minutes = minutes))
    }

    override fun setRoutineExerciseBuilderRestSeconds(seconds: Int) {
        _routineExerciseBuilder.value = _routineExerciseBuilder.value.copy(rest = _routineExerciseBuilder.value.rest.copy(seconds = seconds))
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
                Saved
            }
        }

    override suspend fun setRoutineId(routineId: Long): SetRoutineResult =
        withContext(Dispatchers.Default) {
            routinesDao.findById(routineId)?.let { routine ->
                changeRoutineName(routine.name)
                setRestTimeBetweenExercisesMinutes(routine.rest.minutes)
                setRestTimeBetweenExercisesSeconds(routine.rest.seconds)
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
        changeRoutineName(initialRoutineName)
        setRestTimeBetweenExercisesMinutes(initialRoutineRestTimeBetweenExercises.minutes)
        setRestTimeBetweenExercisesSeconds(initialRoutineRestTimeBetweenExercises.seconds)
        setRoutineExercises(initialRoutineExercises)
        setInitialRoutineExerciseBuilder()
    }

    private suspend fun setRoutineExercises(newList: List<RoutineExercise>) {
        withContext(Dispatchers.Default) {
            _routineExercises.emit(newList)
        }
    }

}


