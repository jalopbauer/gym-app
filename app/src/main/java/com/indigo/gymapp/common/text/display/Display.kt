package com.indigo.gymapp.common.text.display

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.TextSize
import com.indigo.gymapp.ui.theme.color.Color.Context

@Composable
fun Display(title: String, textSize : TextSize = Small, color: Color = Context.Text.primary) {
    Text(
        text = title,
        color = color,
        style = when(textSize) {
            Large -> MaterialTheme.typography.displayLarge
            Medium -> MaterialTheme.typography.displayMedium
            Small -> MaterialTheme.typography.displaySmall
        }
    )
}