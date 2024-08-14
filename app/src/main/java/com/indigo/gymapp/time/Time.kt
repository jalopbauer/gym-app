package com.indigo.gymapp.time

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

data class Time(val minutes: Int, val seconds : Int) {
    override fun toString(): String {
        return "$minutes:${displaySeconds(seconds)}"
    }
}
typealias Rest = Time
typealias Duration = Time