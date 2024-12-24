package com.indigo.gymapp.common.circularTimer

import android.os.CountDownTimer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CircularTimer(
    totalTimeInMillis: Long,
    onTimeEnd: () -> Unit,
) {

    var timeLeft by remember { mutableFloatStateOf(totalTimeInMillis.toFloat()) }

    val progress = { timeLeft / totalTimeInMillis }

    LaunchedEffect(totalTimeInMillis) {
        object : CountDownTimer(totalTimeInMillis, 16) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished.toFloat()
            }

            override fun onFinish() {
                timeLeft = 0f
                onTimeEnd()
            }
        }.start()
    }
    CircularProgressIndicator(
        progress = progress,
        color = MaterialTheme.colorScheme.surface,
        trackColor = MaterialTheme.colorScheme.tertiary,
        strokeWidth = 5.dp,
        modifier = Modifier.size(200.dp)
    )
}