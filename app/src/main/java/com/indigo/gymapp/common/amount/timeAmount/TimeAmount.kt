package com.indigo.gymapp.common.amount.timeAmount

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.time.Time

@Composable
fun TimeAmount(
    time: Time,
    textColor: Color
) {
    Row {
        Title(
            title = "$time",
            color = textColor,
            textSize = Large
        )
    }
}
