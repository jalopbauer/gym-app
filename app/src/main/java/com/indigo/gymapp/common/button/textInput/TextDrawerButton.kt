package com.indigo.gymapp.common.button.textInput

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
import androidx.compose.ui.text.style.TextAlign
import com.indigo.gymapp.common.amount.intAmount.IntAmount
import com.indigo.gymapp.common.amount.timeAmount.TimeAmount
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.time.Time
import com.indigo.gymapp.ui.number.Number.Component.Button

@Composable
private fun TextDrawerButton(
    leadingText: String,
    isOnlyText: Boolean = false,
    isTextCentered: Boolean = false,
    isSelected: Boolean = false,
    onClick: () -> Unit,
    @FloatRange(from = 0.0, to = 1.0) maxWidthFraction: Float = 1f,
    content: @Composable () -> Unit = {},
) {
    val color = if (isOnlyText && isSelected || !isOnlyText) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(maxWidthFraction)
            .clickable { onClick() }
            .height(Button.minimumHeight),
    ) {
        Title(
            modifier = Modifier.weight(1f),
            textAlign = if (isTextCentered) TextAlign.Center else TextAlign.Start,
            title = leadingText,
            color = color,
        )
        content()
    }
}

@Composable
fun TimeAmountTextDrawerButton(
    leadingText: String,
    onClick: () -> Unit,
    time: Time
) {
    TextDrawerButton(
        leadingText = leadingText,
        onClick = onClick,
        content = {
            TimeAmount(
                time = time,
                textColor = MaterialTheme.colorScheme.onPrimary
            )
        }
    )
}

@Composable
fun IntAmountTextDrawerButton(
    leadingText: String,
    amount: Int,
    onClick: () -> Unit
) {
    TextDrawerButton(
        leadingText = leadingText,
        onClick = onClick,
        content = {
            IntAmount(
                amount = amount,
                textColor = MaterialTheme.colorScheme.onPrimary
            )
        }
    )
}

@Composable
fun OnlyTextDrawerButton(
    leadingText: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    TextDrawerButton(
        leadingText = leadingText,
        isOnlyText = true,
        isSelected = isSelected,
        isTextCentered = true,
        onClick = onClick
    )
}

@Composable
fun HeaderTextDrawerButton(
    title: String,
    isSelected: Boolean = false,
    onClick: () -> Unit,
) {
    TextDrawerButton(
        leadingText = title,
        isOnlyText = true,
        isTextCentered = true,
        isSelected = isSelected,
        onClick = onClick,
        maxWidthFraction = 0.82f
    )
}