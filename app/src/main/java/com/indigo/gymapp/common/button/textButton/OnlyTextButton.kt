package com.indigo.gymapp.common.button.textButton

import androidx.compose.runtime.Composable

@Composable
fun OnlyTextButton(text: String, onClick: () -> Unit) {
    TextButton(
        text = text,
        textButtonVariant = OnlyText,
        onClick = onClick
    )
}