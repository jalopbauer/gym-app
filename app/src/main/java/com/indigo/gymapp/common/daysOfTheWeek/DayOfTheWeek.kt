package com.indigo.gymapp.common.daysOfTheWeek

sealed interface DayOfTheWeek

object Monday : DayOfTheWeek
object Tuesday : DayOfTheWeek
object Wednesday : DayOfTheWeek
object Thursday : DayOfTheWeek
object Friday : DayOfTheWeek
object Saturday : DayOfTheWeek
object Sunday : DayOfTheWeek

fun getDayFirstLetter(day: DayOfTheWeek): String =
    when (day) {
        is Monday -> "M"
        is Tuesday -> "T"
        is Wednesday -> "W"
        is Thursday -> "T"
        is Friday -> "F"
        is Saturday -> "S"
        is Sunday -> "S"
    }