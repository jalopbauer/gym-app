package com.indigo.gymapp.common.button.textButton

import androidx.compose.runtime.Composable

@Composable
fun IntAmountTextButton(
    text: String,
    amount: Int,
    onClick: () -> Unit
) {
    TextButton(
        text = text,
        textButtonVariant = TrailingText(text = "$amount"),
        onClick = onClick,
    )
}