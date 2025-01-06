package com.indigo.gymapp.common.timer.circular

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CircularTimer(
    progress: () -> Float,
) {
    CircularProgressIndicator(
        progress = progress,
        color = MaterialTheme.colorScheme.surface,
        trackColor = MaterialTheme.colorScheme.tertiary,
        strokeWidth = 5.dp,
        modifier = Modifier.size(200.dp)
    )
}