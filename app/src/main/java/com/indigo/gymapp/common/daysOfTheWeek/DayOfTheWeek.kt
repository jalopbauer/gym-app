package com.indigo.gymapp.common.daysOfTheWeek

import java.time.LocalDate

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

fun getDayFullName(day: DayOfTheWeek): String =
    when (day) {
        is Monday -> "Monday"
        is Tuesday -> "Tuesday"
        is Wednesday -> "Wednesday"
        is Thursday -> "Thursday"
        is Friday -> "Friday"
        is Saturday -> "Saturday"
        is Sunday -> "Sunday"
    }

fun getDayFromFullName(name: String): DayOfTheWeek = when (name.uppercase()) {
    "MONDAY" -> Monday
    "TUESDAY" -> Tuesday
    "WEDNESDAY" -> Wednesday
    "THURSDAY" -> Thursday
    "FRIDAY" -> Friday
    "SATURDAY" -> Saturday
    "SUNDAY" -> Sunday
    else -> throw IllegalArgumentException("Invalid day name: $name")
}

fun getDayFromInt(number: Int): DayOfTheWeek = when (number) {
    1 -> Monday
    2 -> Tuesday
    3 -> Wednesday
    4 -> Thursday
    5 -> Friday
    6 -> Saturday
    7 -> Sunday
    else -> throw IllegalArgumentException("Invalid day name: $number")
}

fun today(): DayOfTheWeek = getDayFromFullName("${LocalDate.now().dayOfWeek}")
