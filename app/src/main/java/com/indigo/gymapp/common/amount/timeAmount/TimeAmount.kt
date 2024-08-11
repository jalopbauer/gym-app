package com.indigo.gymapp.common.amount.timeAmount

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.classkaty.time.displaySeconds

@Composable
fun TimeAmount(
    minutes: Int,
    seconds: Int,
    textColor: Color
) {
    val displaySeconds = displaySeconds(seconds)
    Row {
        Text(
            text = "$minutes",
            color = textColor,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = ":",
            color = textColor,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = displaySeconds,
            color = textColor,
            style = MaterialTheme.typography.titleLarge
        )
    }
}
