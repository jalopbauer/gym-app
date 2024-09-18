package com.indigo.gymapp.common.amount.timeAmount

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.indigo.gymapp.domain.time.Time

@Composable
fun TimeAmount(
    time: Time,
    textColor: Color
) {
    Row {
        Text(
            text = "$time",
            color = textColor,
            style = MaterialTheme.typography.titleLarge
        )
    }
}
