package com.indigo.gymapp.common.timer.rest

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.display.Display
import com.indigo.gymapp.common.timer.circular.CircularTimer
import com.indigo.gymapp.time.Rest
import com.indigo.gymapp.time.fromMillis
import com.indigo.gymapp.time.toMillis

@Composable
fun RestTimer(
    rest: Rest,
    onTimeEnd: () -> Unit
) {
    val totalTimeInMillis = toMillis(
        rest
    )

    var timeLeft by remember { mutableFloatStateOf(totalTimeInMillis.toFloat()) }

    val progress: () -> Float = { timeLeft / totalTimeInMillis }

    LaunchedEffect(totalTimeInMillis) {
        val timer: CountDownTimer = object : CountDownTimer(totalTimeInMillis, 16) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished.toFloat()
            }

            override fun onFinish() {
                timeLeft = 0f
                onTimeEnd()
            }
        }
        timer.start()
    }

    Box (
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        CircularTimer(
            progress
        )
        Countdown(
            fromMillis(timeLeft.toLong())
        )
    }
}

@Composable
private fun Countdown(rest: Rest) {
    Display(
        display = "$rest",
        textSize = Medium
    )
}
