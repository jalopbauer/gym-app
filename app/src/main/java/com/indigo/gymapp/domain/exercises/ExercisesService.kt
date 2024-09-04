package com.indigo.gymapp.domain.exercises

import android.content.Context

interface ExercisesService {
    fun getExercises(context: Context, onSuccess: (List<Exercise>) -> Unit, onFail: () -> Unit, loadingFinished: () -> Unit)
}