package com.indigo.gymapp.common.text.title

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
fun Title(title: String, textSize : TextSize = Small, color: Color = Context.Text.primary) {
    Text(
        text = title,
        color = color,
        style = when(textSize) {
                    Large -> MaterialTheme.typography.titleLarge
                    Medium -> MaterialTheme.typography.titleMedium
                    Small -> MaterialTheme.typography.titleLarge
                }
    )
}
