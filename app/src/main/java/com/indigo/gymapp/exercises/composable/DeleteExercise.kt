package com.indigo.gymapp.exercises.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.delete.Delete

@Composable
fun DeleteExercise(cancelOnClick: () -> Unit, deleteOnClick: () -> Unit) {
    Delete(
        deleteDescription = stringResource(R.string.deleting_this_exercise_will_delete_all_exercises_in_your_routines),
        cancelOnClick = cancelOnClick,
        deleteOnClick = deleteOnClick
    )
}