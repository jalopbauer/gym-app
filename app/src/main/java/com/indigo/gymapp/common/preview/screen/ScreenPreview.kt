package com.indigo.gymapp.common.preview.screen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun ScreenPreview(
    content: @Composable () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .width(720.dp)
            .height(1280.dp),
        color = Color.Context.Surface.base
    ) {
        content()
    }
}