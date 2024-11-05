package com.indigo.gymapp.common.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.ui.spacing.Spacing
import com.indigo.gymapp.ui.theme.color.Color


@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonVariant : ButtonVariant = Primary,
) {
    androidx.compose.material3.Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        border = when (buttonVariant) {
            Danger, Primary -> null
            Secondary -> BorderStroke(Spacing.Context.BorderStroke.default, MaterialTheme.colorScheme.secondary)
        },
        colors = when (buttonVariant) {
            Primary -> Color.Component.Button.primaryButtonColor()
            Danger -> Color.Component.Button.dangerButtonColor()
            Secondary -> Color.Component.Button.secondaryButtonColor()
        },
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        Title(
            title = text,
            textSize = Large,
            color = when (buttonVariant) {
                Danger, Primary -> MaterialTheme.colorScheme.primary
                Secondary -> MaterialTheme.colorScheme.secondary
            }
        )
    }
}

sealed interface ButtonVariant

data object Primary : ButtonVariant

data object Secondary : ButtonVariant

data object Danger : ButtonVariant
