package com.indigo.gymapp.common.button.textButton

import androidx.compose.runtime.Composable
import com.indigo.gymapp.time.Time

@Composable
fun TimeAmountTextButton(
    text: String,
    time: Time,
    onClick: () -> Unit
) {
    TextButton(
        text = text,
        textButtonVariant = TrailingText(text = "$time"),
        onClick = onClick
    )
}