package com.indigo.gymapp.addRoutine.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.iconTextValue.IconTextValue
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun SetExerciseIconTextValue(exercise: SetExercise) {
    Row (horizontalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default),) {
        IconTextValue(Icons.Outlined.Face, "Amount of sets", "Sets") {
            Body(body = "${exercise.amountOfSets}")
        }
        IconTextValue(Icons.Outlined.AccountBox, "Rest between sets", "Rest") {
            Body(body = "${exercise.rest}")
        }
    }
}