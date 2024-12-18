package com.indigo.gymapp.calendar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.calendar.day.composable.CalendarDays
import com.indigo.gymapp.calendar.event.RoutineEvent
import com.indigo.gymapp.calendar.viewModel.CalendarViewModel
import com.indigo.gymapp.common.daysOfTheWeek.Friday
import com.indigo.gymapp.common.daysOfTheWeek.Thursday
import com.indigo.gymapp.common.daysOfTheWeek.Tuesday
import com.indigo.gymapp.common.daysOfTheWeek.Wednesday
import com.indigo.gymapp.common.header.TextHeader
import com.indigo.gymapp.common.navigation.NavigationIndex
import com.indigo.gymapp.common.page.AddEditPage
import com.indigo.gymapp.common.page.HeaderPage
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import com.indigo.gymapp.time.Duration
import kotlinx.coroutines.launch

@Composable
fun CalendarPage() {

    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()
    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setNavigation(NavigationIndex.CALENDAR)
    }

    val calendarViewModel = hiltViewModel<CalendarViewModel>()
    val calendarDays = calendarViewModel.calendarDays.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    AddEditPage(
        addOnClick = {
            coroutineScope.launch {
                calendarViewModel.createExercise(
                    RoutineEvent(
                        routineId = 1,
                        name = "Push",
                        estimatedDuration = Duration(
                            hours = 1,
                            minutes = 30
                        ),
                        daysOfTheWeek = setOf(
                            Tuesday,
                            Thursday
                        )
                    ),
                )
                calendarViewModel.createExercise(
                    RoutineEvent(
                        routineId = 2,
                        name = "Pull",
                        estimatedDuration = Duration(
                            hours = 2,
                            minutes = 0
                        ),
                        daysOfTheWeek = setOf(
                            Wednesday,
                            Friday
                        )
                    )
                )
            }
        },
        editOnClick = { },
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