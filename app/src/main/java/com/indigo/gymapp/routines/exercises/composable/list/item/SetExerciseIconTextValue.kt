package com.indigo.gymapp.routines.exercises.composable.list.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.icon.SetRoutineExercise
import com.indigo.gymapp.common.icon.TimedRoutineExercise
import com.indigo.gymapp.common.iconTextValue.IconTextValue
import com.indigo.gymapp.routines.exercises.SetExercise
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun SetExerciseIconTextValue(exercise: SetExercise) {
    Row (horizontalArrangement = Arrangement.spacedBy(Gap.default)) {
        IconTextValue(
            iconVariant = SetRoutineExercise,
            label = stringResource(id = R.string.sets),
            value = "${exercise.amountOfSets}"
        )
        IconTextValue(
            iconVariant = TimedRoutineExercise,
            label = stringResource(id = R.string.rest),
            value = "${exercise.rest}"
        )
    }
}