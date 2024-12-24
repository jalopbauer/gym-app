package com.indigo.gymapp.calendar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.calendar.day.composable.CalendarDays
import com.indigo.gymapp.calendar.viewModel.CalendarViewModel
import com.indigo.gymapp.common.header.TextHeader
import com.indigo.gymapp.common.navigation.NavigationIndex
import com.indigo.gymapp.common.page.AddEditPage
import com.indigo.gymapp.common.page.HeaderPage
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel

@Composable
fun CalendarPage(
    onNavigateToCreateEvent : () -> Unit,
    onNavigateToEditEvents : () -> Unit,
) {

    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()
    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setNavigation(NavigationIndex.CALENDAR)
    }

    val calendarViewModel = hiltViewModel<CalendarViewModel>()
    val calendarDays = calendarViewModel.calendarDays.collectAsState()

    AddEditPage(
        addOnClick = onNavigateToCreateEvent,
        editOnClick = onNavigateToEditEvents,
    ) {
        HeaderPage(
            header = {
                TextHeader(
                    text = stringResource(R.string.calendar)
                )
            },
            topPadding = true
        ) {
            CalendarDays(
                calendarDays = calendarDays.value,
                onClick = { },
            )
        }
    }
}