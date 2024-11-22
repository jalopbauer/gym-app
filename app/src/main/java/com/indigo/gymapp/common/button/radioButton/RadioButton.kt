package com.indigo.gymapp.common.button.radioButton

import androidx.compose.runtime.Composable
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun RadioButton(selected: Boolean, onClick: () -> Unit) {
    androidx.compose.material3.RadioButton(
        selected = selected,
        onClick = onClick,
        colors = Color.Component.radioButtonColors()
    )
}