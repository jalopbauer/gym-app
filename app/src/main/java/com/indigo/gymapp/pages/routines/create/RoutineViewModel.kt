package com.indigo.gymapp.pages.routines.create

import androidx.annotation.IntRange
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor(private val routineManager: RoutineManager) : ViewModel(), RoutineHandler {

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
}