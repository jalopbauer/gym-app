package com.indigo.gymapp.common.daysOfTheWeek.descriptor.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek
import com.indigo.gymapp.common.daysOfTheWeek.Monday
import com.indigo.gymapp.common.daysOfTheWeek.getDayFirstLetter
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.body.Body

@Composable
fun DaysOfTheWeekDescriptorItem(day: DayOfTheWeek) {
    Body(
        body = getDayFirstLetter(day),
        textSize = Large
    )

}

@Preview
@Composable
private fun DaysOfTheWeekDescriptorItemPreview() {
    DaysOfTheWeekDescriptorItem(
        day = Monday
    )
}
