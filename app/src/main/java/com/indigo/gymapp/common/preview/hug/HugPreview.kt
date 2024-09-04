package com.indigo.gymapp.common.preview.hug

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun HugPreview(
    content: @Composable () -> Unit = {}
) {
    Surface(
        color = Color.Context.Surface.base
    ) {
        content()
    }
}