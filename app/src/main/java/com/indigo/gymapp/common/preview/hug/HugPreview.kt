package com.indigo.gymapp.common.preview.hug

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

@Composable
fun HugPreview(
    content: @Composable () -> Unit = {}
) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        content()
    }
}