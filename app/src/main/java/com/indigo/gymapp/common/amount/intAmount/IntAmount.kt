package com.indigo.gymapp.common.amount.intAmount

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun IntAmount(
    amount: Int,
    textColor: Color
) {
    Text(
        text = "$amount",
        color = textColor,
        style = MaterialTheme.typography.titleLarge
    )
}