package com.indigo.gymapp.common.button.textButton

import androidx.compose.runtime.Composable

@Composable
fun CenteredTextButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    TextButton(
        text = text,
        textButtonVariant = Centered(selected = selected),
        onClick = onClick
    )
}