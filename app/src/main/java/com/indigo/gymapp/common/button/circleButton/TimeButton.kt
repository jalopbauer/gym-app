package com.indigo.gymapp.common.button.circleButton

import androidx.compose.runtime.Composable
import com.indigo.gymapp.time.Time
import com.indigo.gymapp.ui.number.Number.Component.Button.TimeButton
import com.indigo.gymapp.ui.theme.color.Color.Component.Button


@Composable
fun TimeButton(
    time: Time,
    onClick: (Time) -> Unit,
) {
    CircleButton(
        text = "$time",
        onClick = { onClick(time) },
        size = TimeButton.diameter,
        padding = TimeButton.padding,
        colors = Button.circleButtonColor()
    )
}