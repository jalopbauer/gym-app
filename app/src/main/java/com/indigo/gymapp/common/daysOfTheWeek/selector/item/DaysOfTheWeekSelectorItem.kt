package com.indigo.gymapp.common.daysOfTheWeek.selector.item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek
import com.indigo.gymapp.common.daysOfTheWeek.Monday
import com.indigo.gymapp.common.daysOfTheWeek.Wednesday
import com.indigo.gymapp.common.daysOfTheWeek.getDayFirstLetter
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.body.Body

@Composable
fun DaysOfTheWeekSelectorItem(day: DayOfTheWeek, selectedDayOfTheWeek: DayOfTheWeek, getDayOnClick : (DayOfTheWeek) -> Unit) {
    val selected = day == selectedDayOfTheWeek
    Row (
        modifier = Modifier
            .size(48.dp)
            .background(selected = selected)
            .clickable { getDayOnClick(day) },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Body(
            body = getDayFirstLetter(day),
            textSize = Large
        )
    }
}

@Composable
private fun Modifier.background(selected: Boolean) : Modifier =
    if (selected) {
        this.background(
            color = MaterialTheme.colorScheme.onSecondary,
            shape = CircleShape
        )
    } else {
        this
    }

@Preview
@Composable
private fun DaysOfTheWeekSelectorItemSelected() {
    DaysOfTheWeekSelectorItem(
        day = Monday,
        selectedDayOfTheWeek = Monday,
        getDayOnClick = { }
    )
}

@Preview
@Composable
private fun DaysOfTheWeekSelectorItemUnselected() {
    DaysOfTheWeekSelectorItem(
        day = Monday,
        selectedDayOfTheWeek = Wednesday,
        getDayOnClick = { }
    )
}