package com.indigo.gymapp.common.button.textButton

import androidx.compose.runtime.Composable

@Composable
fun HeaderTextButton(
    text: String,
    selected: Boolean = false,
    onClick: () -> Unit,
) {
    TextButton(
        text = text,
        textButtonVariant = Centered(selected = selected),
        maxWidthFraction = 0.82f,
        onClick = onClick,
    )
}