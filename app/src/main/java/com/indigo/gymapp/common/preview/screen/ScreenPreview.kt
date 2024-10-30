package com.indigo.gymapp.common.preview.screen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenPreview(
    content: @Composable () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .width(720.dp)
            .height(1280.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        content()
    }
}