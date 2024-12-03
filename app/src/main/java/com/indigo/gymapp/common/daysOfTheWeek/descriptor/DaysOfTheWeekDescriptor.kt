package com.indigo.gymapp.common.daysOfTheWeek.descriptor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.daysOfTheWeek.Friday
import com.indigo.gymapp.common.daysOfTheWeek.Monday
import com.indigo.gymapp.common.daysOfTheWeek.Saturday
import com.indigo.gymapp.common.daysOfTheWeek.Sunday
import com.indigo.gymapp.common.daysOfTheWeek.Thursday
import com.indigo.gymapp.common.daysOfTheWeek.Tuesday
import com.indigo.gymapp.common.daysOfTheWeek.Wednesday
import com.indigo.gymapp.common.daysOfTheWeek.descriptor.item.DaysOfTheWeekDescriptorItem
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun DaysOfTheWeekDescriptor(
    monday: Boolean,
    tuesday: Boolean,
    wednesday: Boolean,
    thursday: Boolean,
    friday: Boolean,
    saturday: Boolean,
    sunday: Boolean,
    sundayFirstDay: Boolean
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Gap.default)
    ) {
        if (sunday && sundayFirstDay) {
            DaysOfTheWeekDescriptorItem(day = Sunday)
        }
        if (monday) {
            DaysOfTheWeekDescriptorItem(day = Monday)
        }
        if (tuesday) {
            DaysOfTheWeekDescriptorItem(day = Tuesday)
        }
        if (wednesday) {
            DaysOfTheWeekDescriptorItem(day = Wednesday)
        }
        if (thursday) {
            DaysOfTheWeekDescriptorItem(day = Thursday)
        }
        if (friday) {
            DaysOfTheWeekDescriptorItem(day = Friday)
        }
        if (saturday) {
            DaysOfTheWeekDescriptorItem(day = Saturday)
        }
        if (sunday && !sundayFirstDay) {
            DaysOfTheWeekDescriptorItem(day = Sunday)
        }
    }
}

@Preview
@Composable
private fun DaysOfTheWeekSelectorSundayIsFirstDayPreview() {
    HugPreview {
        DaysOfTheWeekDescriptor (
            monday = true,
            tuesday = true,
            wednesday = true,
            thursday = true,
            friday = true,
            saturday = true,
            sunday = true,
            sundayFirstDay = true,
        )
    }
}

@Preview
@Composable
private fun DaysOfTheWeekSelectorSundayIsNotFirstDayPreview() {
    HugPreview {
        DaysOfTheWeekDescriptor (
            monday = true,
            tuesday = true,
            wednesday = true,
            thursday = true,
            friday = true,
            saturday = true,
            sunday = true,
            sundayFirstDay = false,
        )
    }
}