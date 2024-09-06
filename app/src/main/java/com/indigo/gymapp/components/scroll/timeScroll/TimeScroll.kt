package com.indigo.gymapp.components.scroll.timeScroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.numberScroll.MinuteAndSecondsVerticalScroll
import com.indigo.gymapp.time.Time

@Composable
fun TimeScroll(
    startingTime: Time,
    selectedMinutes: (Int) -> Unit,
    selectedSeconds: (Int) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MinuteAndSecondsVerticalScroll(
            label = "Minutes",
            startingIndex = startingTime.minutes,
            selectedItem = selectedMinutes
        )
        MinuteAndSecondsVerticalScroll(
            label = "Seconds",
            startingIndex = startingTime.seconds,
            selectedItem = selectedSeconds
        )
    }
}