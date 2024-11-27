package com.indigo.gymapp.routines.exercises.composable.list.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.icon.TimedRoutineExercise
import com.indigo.gymapp.common.iconTextValue.IconTextValue
import com.indigo.gymapp.routines.exercises.TimedExercise

@Composable
fun TimedExerciseIconTextValue(exercise: TimedExercise) {
    IconTextValue(
        iconVariant = TimedRoutineExercise,
        label = stringResource(id = R.string.duration),
        value = "${exercise.duration}"
    )
}