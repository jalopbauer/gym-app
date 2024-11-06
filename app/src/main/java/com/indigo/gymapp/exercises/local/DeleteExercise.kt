package com.indigo.gymapp.exercises.local

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.button.Danger
import com.indigo.gymapp.common.button.Secondary
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun DeleteExercise(cancelOnClick: () -> Unit, deleteOnClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Context.Gap.medium)
    ) {
        Headline(headline = stringResource(R.string.deleting_this_exercise_will_delete_all_exercises_in_your_routines))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Context.Gap.default)
        ) {
            Button(
                text = stringResource(R.string.cancel),
                onClick = cancelOnClick,
                modifier = Modifier.weight(1f),
                buttonVariant = Secondary
            )
            Button(
                text = stringResource(R.string.delete),
                onClick = deleteOnClick,
                modifier = Modifier.weight(1f),
                buttonVariant = Danger
            )
        }
    }
}