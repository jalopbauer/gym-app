package com.indigo.gymapp.common.textField

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.ui.theme.color.Color.Component


@Composable
fun TextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
) {
    androidx.compose.material3.TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Title(
                title = label,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        colors = Component.textFieldColorsField()
    )
}