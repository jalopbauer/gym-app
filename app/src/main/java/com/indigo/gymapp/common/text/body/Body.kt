package com.indigo.gymapp.common.text.body

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.TextSize

@Composable
fun Body(body: String, textSize : TextSize = Small) {
    Text(
        text = body,
        color = MaterialTheme.colorScheme.primary,
        style = when(textSize) {
                    Large -> MaterialTheme.typography.bodyLarge
                    Medium -> MaterialTheme.typography.bodyMedium
                    Small -> MaterialTheme.typography.bodySmall
                }
    )
}