package com.indigo.gymapp.common.button.circleButton

import androidx.compose.runtime.Composable
import com.indigo.gymapp.time.Time

@Composable
fun TimeButton(
    time: Time,
    onClick: (Time) -> Unit,
) {
    CircleButton(
        text = "$time",
        onClick = { onClick(time) }
    )
}