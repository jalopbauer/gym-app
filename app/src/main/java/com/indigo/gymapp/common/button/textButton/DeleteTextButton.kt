package com.indigo.gymapp.common.button.textButton

import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.icon.Delete

@Composable
fun DeleteTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        text = text,
        textButtonVariant = TrailingIcon(Delete, onClick),
        onClick = onClick,
    )
}