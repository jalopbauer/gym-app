package com.indigo.gymapp.addRoutine.addExercise.type.timed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.textInput.OnlyTextDrawerButton
import com.indigo.gymapp.common.button.textInput.TimeAmountTextDrawerButton
import com.indigo.gymapp.common.preview.screen.ScreenPreview

@Composable
fun AddTimed() {
    val onClick = { /*TODO*/ }
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        OnlyTextDrawerButton(
            leadingText = stringResource(id = R.string.select_exercise),
            onClick = onClick
        )
        TimeAmountTextDrawerButton(
            leadingText = stringResource(id = R.string.duration),
            minutes = 30,
            seconds = 0,
            onClick = onClick,
        )
    }
}


@Preview
@Composable
private fun PreviewAddSet() {
    ScreenPreview {
        AddTimed()
    }
}