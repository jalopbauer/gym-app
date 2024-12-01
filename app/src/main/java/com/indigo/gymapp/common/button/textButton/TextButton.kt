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
        modifier = clickableModifier(
            Modifier
                .fillMaxWidth(maxWidthFraction)
                .height(Button.minimumHeight),
            textButtonVariant = textButtonVariant,
            onClick
        )
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
        is TrailingText, is TrailingIcon -> Arrangement.SpaceBetween
        is Centered -> Arrangement.Center
    }

@Composable
private fun textColor(textButtonVariant : TextButtonVariant): Color =
    when (textButtonVariant) {
        is TrailingText, is TrailingIcon -> MaterialTheme.colorScheme.primary
        is Centered -> if (textButtonVariant.selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
    }

@Composable
private fun Leading(textButtonVariant : TextButtonVariant) =
    when (textButtonVariant) {
        is Centered -> {}
        is TrailingText ->
            textButtonVariant.text?.let {
                Title(
                    title = textButtonVariant.text,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textSize = Large
                )
        }
        is TrailingIcon -> {
            IconButton(iconVariant = textButtonVariant.iconVariant, onClick = textButtonVariant.onClick)
        }
    }

@Composable
private fun clickableModifier(modifier: Modifier, textButtonVariant : TextButtonVariant, onClick: () -> Unit) : Modifier =
    when (textButtonVariant) {
        is Centered, is TrailingText -> modifier.clickable { onClick() }
        is TrailingIcon -> modifier
    }


sealed interface TextButtonVariant

sealed interface Trailing: TextButtonVariant

data class TrailingText(val text: String? = null) : Trailing

data class TrailingIcon(val iconVariant: IconVariant, val onClick: () -> Unit) : Trailing

data class Centered(val selected: Boolean) : TextButtonVariant