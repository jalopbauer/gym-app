package com.indigo.gymapp.service.api.exercises

import android.content.Context

interface ExercisesService {
    fun getExercises(context: Context, onSuccess: (List<Exercise>) -> Unit, onFail: () -> Unit, loadingFinished: () -> Unit)
}