package com.indigo.gymapp.time

import androidx.annotation.IntRange

fun displaySeconds(seconds: Int) : String = if (seconds in 0 .. 9) "0$seconds" else "$seconds"

data class Time(
    @IntRange(from = 0, to = 59)
    val minutes: Int,
    @IntRange(from = 0, to = 59)
    val seconds : Int
) {
    override fun toString(): String {
        return "$minutes:${displaySeconds(seconds)}"
    }
}
typealias Rest = Time
typealias Duration = Time