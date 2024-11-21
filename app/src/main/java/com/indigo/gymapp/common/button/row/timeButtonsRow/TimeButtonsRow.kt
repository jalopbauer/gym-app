package com.indigo.gymapp.common.button.row.timeButtonsRow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.button.timeButton.TimeButton
import com.indigo.gymapp.time.Time
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun TimeButtonsRow(
    leftTime: Time,
    leftTimeOnClick: (Time) -> Unit,
    centerTime: Time,
    centerTimeOnClick: (Time) -> Unit,
    rightTime: Time,
    rightTimeOnClick: (Time) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = Gap.circleButton,
            alignment = Alignment.CenterHorizontally
        ),
    ) {
        TimeButton(
            time = leftTime,
            onClick = leftTimeOnClick
        )
        TimeButton(
            time = centerTime,
            onClick = centerTimeOnClick
        )
        TimeButton(
            time = rightTime,
            onClick = rightTimeOnClick
        )
    }
}