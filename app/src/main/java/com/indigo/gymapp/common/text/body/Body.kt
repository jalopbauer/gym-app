package com.indigo.gymapp.common.text.body

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.TextSize
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun Body(body: String, textSize : TextSize = Small) {
    Text(
        text = body,
        color = Color.Context.Text.primary,
        style = MaterialTheme.typography.bodySmall
    )
}