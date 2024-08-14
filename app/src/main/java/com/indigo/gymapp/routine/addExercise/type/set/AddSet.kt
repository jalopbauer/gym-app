package com.indigo.gymapp.routine.addExercise.type.set

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.button.textInput.IntAmountTextDrawerButton
import com.indigo.gymapp.common.button.textInput.OnlyTextDrawerButton
import com.indigo.gymapp.common.button.textInput.TimeAmountTextDrawerButton
import com.indigo.gymapp.common.preview.screen.ScreenPreview

@Composable
fun AddSet() {
    val onClick = { /*TODO*/ }
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        OnlyTextDrawerButton(
            leadingText = "Select Exercise",
            onClick = onClick
        )
        TimeAmountTextDrawerButton(
            leadingText = "Rest between exercises",
            minutes = 2,
            seconds = 0,
            onClick = onClick
        )
        IntAmountTextDrawerButton(
            leadingText = "Amount of sets",
            amount = 4,
            onClick = onClick
        )
    }
}


@Preview
@Composable
private fun PreviewAddSet() {
    ScreenPreview {
        AddSet()
    }
}