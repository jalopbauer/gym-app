package com.indigo.gymapp.components.scroll.timeScroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.R
import com.indigo.gymapp.common.numberScroll.VerticalNumberScroll
import com.indigo.gymapp.domain.time.Time
import com.indigo.gymapp.domain.time.displaySeconds

@Composable
fun TimeScroll(
    startingTime: Time,
    selectedMinutes: (Int) -> Unit,
    selectedSeconds: (Int) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space = 32.dp, alignment = Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        VerticalNumberScroll(
            label = stringResource(R.string.minutes),
            startingIndex = startingTime.minutes,
            maxValue = 59,
            selectedItem = selectedMinutes
        )
        VerticalNumberScroll(
            label = stringResource(R.string.seconds),
            startingIndex = startingTime.seconds,
            selectedItem = selectedSeconds,
            maxValue = 59,
            indexDisplay = { displaySeconds(it) }
        )
    }
}