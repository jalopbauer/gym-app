package com.indigo.gymapp.routines.manager

import androidx.annotation.IntRange
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

    private var _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private var _restTimeBetweenExercises = MutableStateFlow(Rest(2, 0))
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

    private var _routineExercises = MutableStateFlow(listOf<RoutineExercise>())
    val exercises = _routineExercises.asStateFlow()

    override suspend fun addExercise(routineExercise: RoutineExercise) {
        val newList = _routineExercises.value + routineExercise.setId(_routineExercises.value.size.toLong())
        withContext(Dispatchers.Default) {
            _routineExercises.emit(newList)
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


    override suspend fun saveRoutine(): SaveRoutineResult =
        when {
            name.value == "" -> MissingName
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

}