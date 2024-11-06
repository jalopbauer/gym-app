package com.indigo.gymapp.routines.exercises.list.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.icon.TimedRoutineExercise
import com.indigo.gymapp.common.iconTextValue.IconTextValue
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.domain.routines.exercises.TimedExercise

@Composable
fun TimedExerciseIconTextValue(exercise: TimedExercise) {
    IconTextValue(
        iconVariant = TimedRoutineExercise,
        text = stringResource(id = R.string.duration)
    ) {
        Body(body = "${exercise.duration}")
    }
}