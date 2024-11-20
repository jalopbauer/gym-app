package com.indigo.gymapp.routines.exercises.composable.list.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.icon.SetRoutineExercise
import com.indigo.gymapp.common.icon.TimedRoutineExercise
import com.indigo.gymapp.common.iconTextValue.IconTextValue
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.routines.exercises.SetExercise
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun SetExerciseIconTextValue(exercise: SetExercise) {
    Row (horizontalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default)) {
        IconTextValue(
            iconVariant = SetRoutineExercise,
            text = stringResource(id = R.string.sets)
        ) {
            Body(body = "${exercise.amountOfSets}")
        }
        IconTextValue(
            iconVariant = TimedRoutineExercise,
            text = stringResource(id = R.string.rest)
        ) {
            Body(body = "${exercise.rest}")
        }
    }
}