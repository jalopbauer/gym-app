package com.indigo.gymapp.common.amount.intAmount

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title

@Composable
fun IntAmount(
    amount: Int,
    textColor: Color
) {
    Title(
        title = "$amount",
        color = textColor,
        textSize = Large
    )
}