package com.indigo.gymapp.components.timeScrollTimeButtonsRow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.button.row.timeButtonsRow.TimeButtonsRow
import com.indigo.gymapp.components.scroll.timeScroll.TimeScroll
import com.indigo.gymapp.time.Rest


@Composable
fun TimeScrollTimeButtonsRow(
    routineRestTimeBetweenExercises: Rest,
    selectedMinutes: (Int) -> Unit,
    selectedSeconds: (Int) -> Unit,
    leftTime: Rest,
    leftTimeOnClick: (Rest) -> Unit,
    centerTime: Rest,
    centerTimeOnClick: (Rest) -> Unit,
    rightTime: Rest,
    rightTimeOnClick: (Rest) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TimeScroll(routineRestTimeBetweenExercises, selectedMinutes, selectedSeconds)
        TimeButtonsRow(
            leftTime,
            leftTimeOnClick,
            centerTime,
            centerTimeOnClick,
            rightTime,
            rightTimeOnClick
        )
    }
}