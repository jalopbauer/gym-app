package com.indigo.gymapp.pages.routines.create

import androidx.annotation.IntRange
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise

interface RoutineHandler {

    fun setRestTimeBetweenExercisesSeconds(@IntRange(from = 0, to = 59) seconds: Int)

    fun setRestTimeBetweenExercisesMinutes(@IntRange(from = 0, to = 59) minutes: Int)

    fun changeRoutineName(newRoutineName: String)

    suspend fun addExercise(routineExercise: RoutineExercise)
}