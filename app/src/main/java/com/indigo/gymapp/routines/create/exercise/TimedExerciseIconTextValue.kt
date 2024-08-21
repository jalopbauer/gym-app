package com.indigo.gymapp.routines.create.exercise

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.iconTextValue.IconTextValue
import com.indigo.gymapp.common.text.body.Body

@Composable
fun TimedExerciseIconTextValue(exercise: TimedExercise) {
    val imageVector = Icons.Outlined.MailOutline

    IconTextValue(
        imageVector = imageVector,
        contentDescription = stringResource(id = R.string.exercise_duration),
        text = stringResource(id = R.string.duration)
    ) {
        Body(body = "${exercise.duration}")
    }
}