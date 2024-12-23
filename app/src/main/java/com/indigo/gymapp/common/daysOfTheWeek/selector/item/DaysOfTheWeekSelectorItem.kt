package com.indigo.gymapp.common.daysOfTheWeek.selector.item

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek
import com.indigo.gymapp.common.daysOfTheWeek.Monday
import com.indigo.gymapp.common.daysOfTheWeek.Wednesday
import com.indigo.gymapp.common.daysOfTheWeek.getDayFirstLetter
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.ui.number.Number
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun DaysOfTheWeekSelectorItem(day: DayOfTheWeek, selectedDayOfTheWeek: Set<DayOfTheWeek>, getDayOnClick: (DayOfTheWeek) -> Unit) {
    val selected = selectedDayOfTheWeek.contains(day)
    Button(
        onClick = { getDayOnClick(day) },
        modifier = Modifier.size(Number.Component.DaysOfTheWeekSelectorItem.diameter),
        shape = CircleShape,
        colors = if (selected) Color.Component.DaysOfTheWeekSelectorItem.selectedDaysOfTheWeekSelectorItem() else Color.Component.DaysOfTheWeekSelectorItem.unselectedDaysOfTheWeekSelectorItem(),
        contentPadding = PaddingValues(Number.Component.DaysOfTheWeekSelectorItem.padding)
    ) {
        Body(
            body = getDayFirstLetter(day),
            textSize = Large
        )
    }
}

@Preview
@Composable
private fun DaysOfTheWeekSelectorItemSelected() {
    DaysOfTheWeekSelectorItem(
        day = Monday,
        selectedDayOfTheWeek = setOf(Monday),
        getDayOnClick = { }
    )
}

@Preview
@Composable
private fun DaysOfTheWeekSelectorItemUnselected() {
    DaysOfTheWeekSelectorItem(
        day = Monday,
        selectedDayOfTheWeek = setOf(Wednesday),
        getDayOnClick = { }
    )
}