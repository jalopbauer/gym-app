package com.indigo.gymapp.common.text.label

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.TextSize

@Composable
fun Label(label: String, textSize : TextSize = Small, color: Color = MaterialTheme.colorScheme.primary) {
    Text(
        text = label,
        color = color,
        style = when(textSize) {
            Large -> MaterialTheme.typography.labelLarge
            Medium -> MaterialTheme.typography.labelMedium
            Small -> MaterialTheme.typography.labelLarge
        }
    )
}