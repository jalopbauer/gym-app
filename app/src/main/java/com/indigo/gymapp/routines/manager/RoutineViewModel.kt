package com.indigo.gymapp.routines.manager

import androidx.annotation.IntRange
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.RoutineExerciseBuilder
import com.indigo.gymapp.exercises.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor(private val routineManager: RoutineManager) : ViewModel(),
    RoutineHandler {

    val name = routineManager.name

    override fun changeRoutineName(newRoutineName: String) {
        routineManager.changeRoutineName(newRoutineName)
    }

    val restTimeBetweenExercises = routineManager.restTimeBetweenExercises

    override fun setRestTimeBetweenExercisesSeconds(@IntRange(from = 0, to = 59) seconds: Int) {
        routineManager.setRestTimeBetweenExercisesSeconds(seconds)
    }

    override fun setRestTimeBetweenExercisesMinutes(@IntRange(from = 0, to = 59) minutes: Int) {
        routineManager.setRestTimeBetweenExercisesMinutes(minutes)
    }

    val exercises = routineManager.exercises

    override suspend fun addExercise(routineExercise: RoutineExercise) {
        viewModelScope.launch {
            routineManager.addExercise(routineExercise)
        }
    }

    val routineExerciseBuilder = routineManager.routineExerciseBuilder

    override fun setRoutineExerciseBuilder(routineExerciseBuilder: RoutineExerciseBuilder) {
        routineManager.setRoutineExerciseBuilder(routineExerciseBuilder)
    }

    override fun setRoutineExerciseBuilderRestMinutes(@IntRange(from = 0, to = 59) minutes: Int) {
        routineManager.setRoutineExerciseBuilderRestMinutes(minutes)
    }

    override fun setRoutineExerciseBuilderRestSeconds(seconds: Int) {
        routineManager.setRoutineExerciseBuilderRestSeconds(seconds)
    }

    override fun setRoutineExerciseBuilderExercise(exercise: Exercise) {
        routineManager.setRoutineExerciseBuilderExercise(exercise)
    }

    override fun setRoutineExerciseBuilderAmountOfSets(amountOfSets: Int) {
        routineManager.setRoutineExerciseBuilderAmountOfSets(amountOfSets)
    }

    override fun setInitialRoutineExerciseBuilder() {
        routineManager.setInitialRoutineExerciseBuilder()
    }

    val routines = routineManager.routines

    override suspend fun saveRoutine(): SaveRoutineResult =
        routineManager.saveRoutine()
}