package com.indigo.gymapp.common.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.ui.theme.color.Color


@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = Color.Component.Button.primaryButtonColor(),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        Title(text, Large)
    }
}