package com.indigo.gymapp.time

import androidx.annotation.IntRange

fun displaySeconds(seconds: Int) : String = if (seconds in 0 .. 9) "0$seconds" else "$seconds"

fun Duration.displayDuration() : String =
    "${this.hours}:${displaySeconds(this.minutes)}"

data class Time(
    val hours: Int = 0,
    @IntRange(from = 0, to = 59)
    val minutes: Int,
    @IntRange(from = 0, to = 59)
    val seconds : Int = 0
) {
    override fun toString(): String {
        return "$minutes:${displaySeconds(seconds)}"
    }
}
typealias Rest = Time
typealias Duration = Time

fun toMillis(rest: Rest): Long {
    return (rest.minutes * 60 * 1000L) + (rest.seconds * 1000L)
}


fun fromMillis(millis: Long): Rest {
    val totalSeconds = millis / 1000
    val minutes = (totalSeconds / 60).toInt()
    val seconds = (totalSeconds % 60).toInt()
    return Rest(minutes = minutes, seconds = seconds)
}