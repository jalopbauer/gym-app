package com.indigo.gymapp.common.daysOfTheWeek.selector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek
import com.indigo.gymapp.common.daysOfTheWeek.Friday
import com.indigo.gymapp.common.daysOfTheWeek.Monday
import com.indigo.gymapp.common.daysOfTheWeek.Saturday
import com.indigo.gymapp.common.daysOfTheWeek.Sunday
import com.indigo.gymapp.common.daysOfTheWeek.Thursday
import com.indigo.gymapp.common.daysOfTheWeek.Tuesday
import com.indigo.gymapp.common.daysOfTheWeek.Wednesday
import com.indigo.gymapp.common.daysOfTheWeek.selector.item.DaysOfTheWeekSelectorItem
import com.indigo.gymapp.common.preview.screen.ScreenPreview

@Composable
fun DaysOfTheWeekSelector(
    sundayFirstDay: Boolean,
    selectedDayOfTheWeek: Set<DayOfTheWeek>,
    getDayOnClick: (DayOfTheWeek) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (sundayFirstDay) {
            DaysOfTheWeekSelectorItem(
                day = Sunday,
                selectedDayOfTheWeek = selectedDayOfTheWeek,
                getDayOnClick = getDayOnClick
            )
        }
        DaysOfTheWeekSelectorItem(
            day = Monday,
            selectedDayOfTheWeek = selectedDayOfTheWeek,
            getDayOnClick = getDayOnClick
        )
        DaysOfTheWeekSelectorItem(
            day = Tuesday,
            selectedDayOfTheWeek = selectedDayOfTheWeek,
            getDayOnClick = getDayOnClick
        )
        DaysOfTheWeekSelectorItem(
            day = Wednesday,
            selectedDayOfTheWeek = selectedDayOfTheWeek,
            getDayOnClick = getDayOnClick
        )
        DaysOfTheWeekSelectorItem(
            day = Thursday,
            selectedDayOfTheWeek = selectedDayOfTheWeek,
            getDayOnClick = getDayOnClick
        )
        DaysOfTheWeekSelectorItem(
            day = Friday,
            selectedDayOfTheWeek = selectedDayOfTheWeek,
            getDayOnClick = getDayOnClick
        )
        DaysOfTheWeekSelectorItem(
            day = Saturday,
            selectedDayOfTheWeek = selectedDayOfTheWeek,
            getDayOnClick = getDayOnClick
        )
        if (!sundayFirstDay) {
            DaysOfTheWeekSelectorItem(
                day = Sunday,
                selectedDayOfTheWeek = selectedDayOfTheWeek,
                getDayOnClick = getDayOnClick
            )
        }

    }
}

@Preview
@Composable
private fun DaysOfTheWeekSelectorSundayIsFirstDayPreview() {
    ScreenPreview {
        DaysOfTheWeekSelector(
            sundayFirstDay = true,
            selectedDayOfTheWeek = setOf(Wednesday, Saturday),
            getDayOnClick = { }
        )
    }
}

@Preview
@Composable
private fun DaysOfTheWeekSelectorSundayIsNotFirstDayPreview() {
    ScreenPreview {
        DaysOfTheWeekSelector(
            sundayFirstDay = false,
            selectedDayOfTheWeek = setOf(Wednesday, Saturday),
            getDayOnClick = { }
        )
    }
}