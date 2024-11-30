package com.indigo.gymapp.exercises.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.deleteButtons.DeleteButtons
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun DeleteExercise(cancelOnClick: () -> Unit, deleteOnClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Gap.medium)
    ) {
        Headline(
            headline = stringResource(R.string.deleting_this_exercise_will_delete_all_exercises_in_your_routines),
            textSize = Small
        )
        DeleteButtons(
            cancelOnClick = cancelOnClick,
            deleteOnClick = deleteOnClick
        )
    }
}