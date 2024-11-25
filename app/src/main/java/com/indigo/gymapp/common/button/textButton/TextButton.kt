package com.indigo.gymapp.common.button.textButton

import androidx.annotation.FloatRange
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.indigo.gymapp.common.button.iconButton.IconButton
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.ui.number.Number.Component.Button

@Composable
fun TextButton(
    text: String,
    textButtonVariant: TextButtonVariant,
    onClick: () -> Unit,
    @FloatRange(from = 0.0, to = 1.0) maxWidthFraction: Float = 1f
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangement(textButtonVariant = textButtonVariant),
        modifier = Modifier
            .fillMaxWidth(maxWidthFraction)
            .clickable(enabled = clickableModifier(textButtonVariant)) { onClick() }
            .height(Button.minimumHeight),
    ) {
        Title(
            title = text,
            color = textColor(textButtonVariant = textButtonVariant),
        )
        Leading(textButtonVariant = textButtonVariant)
    }
}

@Composable
private fun horizontalArrangement(textButtonVariant : TextButtonVariant) : Arrangement.Horizontal =
    when (textButtonVariant) {
        is Text, is TrailingIcon -> Arrangement.SpaceBetween
        is Centered -> Arrangement.Center
    }

@Composable
private fun textColor(textButtonVariant : TextButtonVariant): Color =
    when (textButtonVariant) {
        is Text, is TrailingIcon -> MaterialTheme.colorScheme.primary
        is Centered -> if (textButtonVariant.selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
    }

@Composable
private fun Leading(textButtonVariant : TextButtonVariant) =
    when (textButtonVariant) {
        is Centered -> {}
        is Text ->
            textButtonVariant.leadingText?.let {
                Title(
                    title = textButtonVariant.leadingText,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textSize = Large
                )
        }
        is TrailingIcon -> {
            IconButton(iconVariant = textButtonVariant.iconVariant, onClick = textButtonVariant.onClick)
        }
    }

private fun clickableModifier(textButtonVariant : TextButtonVariant) : Boolean =
    when (textButtonVariant) {
        is Centered, is Text -> true
        is TrailingIcon -> false
    }


sealed interface TextButtonVariant

sealed interface Left : TextButtonVariant

data class Text(val leadingText: String? = null) : Left

data class TrailingIcon(val iconVariant: IconVariant, val onClick: () -> Unit) : Left

data class Centered(val selected: Boolean) : TextButtonVariant