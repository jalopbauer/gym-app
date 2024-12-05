package com.indigo.gymapp.common.preview.hug

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.indigo.gymapp.ui.theme.GymAppTheme

@Composable
fun HugPreview(
    content: @Composable () -> Unit = {}
) {
    GymAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}