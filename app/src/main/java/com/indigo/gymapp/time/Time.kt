package com.indigo.gymapp.time

import androidx.annotation.IntRange

fun displaySeconds(seconds: Int) = when (seconds) {
    0 -> "00"
    1 -> "01"
    2 -> "02"
    3 -> "03"
    4 -> "04"
    5 -> "05"
    6 -> "06"
    7 -> "07"
    8 -> "08"
    9 -> "09"
    else -> "$seconds"
}

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