package com.indigo.gymapp.common.textField

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.ui.theme.color.Color.Context


@Composable
fun CustomTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Title(
                title = label,
                color = Context.Text.information
            )
        },
        colors = TextFieldDefaults.colors().copy(
            unfocusedContainerColor = Context.Surface.base,
            focusedContainerColor = Context.Surface.base,
            cursorColor = Context.Icon.active,
            unfocusedIndicatorColor = Context.Surface.base,
            focusedIndicatorColor = Context.Icon.active,
            focusedTextColor = Context.Text.primary,
            unfocusedTextColor = Context.Text.primary
        )
    )
}