package com.indigo.gymapp.common.text.headline

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.TextSize
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun Headline(headline: String, textSize : TextSize = Small) {
    Text(
        text = headline,
        color = Color.Context.Text.primary,
        style = MaterialTheme.typography.headlineSmall
    )
}