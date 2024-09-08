package com.indigo.gymapp.components.timeScrollTimeButtonsRowConfirm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.R
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.button.row.timeButtonsRow.TimeButtonsRow
import com.indigo.gymapp.components.scroll.timeScroll.TimeScroll
import com.indigo.gymapp.time.Rest


@Composable
fun TimeScrollTimeButtonsRowConfirm(
    routineRestTimeBetweenExercises: Rest,
    selectedMinutes: (Int) -> Unit,
    selectedSeconds: (Int) -> Unit,
    leftTime: Rest,
    leftTimeOnClick: (Rest) -> Unit,
    centerTime: Rest,
    centerTimeOnClick: (Rest) -> Unit,
    rightTime: Rest,
    rightTimeOnClick: (Rest) -> Unit,
    confirmOnClick: () -> Unit,
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
        Button(
            text = stringResource(R.string.confirm),
            onClick = confirmOnClick
        )
    }
}