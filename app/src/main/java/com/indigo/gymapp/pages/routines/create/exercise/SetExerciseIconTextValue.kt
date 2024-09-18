package com.indigo.gymapp.pages.routines.create.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.iconTextValue.IconTextValue
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun SetExerciseIconTextValue(exercise: SetExercise) {
    Row (horizontalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default)) {
        IconTextValue(
            imageVector = Icons.Outlined.Face,
            contentDescription = stringResource(id = R.string.amount_of_sets),
            text = stringResource(id = R.string.sets)
        ) {
            Body(body = "${exercise.amountOfSets}")
        }
        IconTextValue(
            imageVector = Icons.Outlined.AccountBox,
            contentDescription = stringResource(id = R.string.rest_between_sets),
            text = stringResource(id = R.string.rest)
        ) {
            Body(body = "${exercise.rest}")
        }
    }
}