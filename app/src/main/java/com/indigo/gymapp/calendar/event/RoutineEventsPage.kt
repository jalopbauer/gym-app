package com.indigo.gymapp.calendar.event


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.calendar.event.composable.Events
import com.indigo.gymapp.calendar.event.viewModel.RoutineEventsViewModel
import com.indigo.gymapp.common.header.TextHeader
import com.indigo.gymapp.common.page.AddPage
import com.indigo.gymapp.common.page.HeaderPage
import kotlinx.coroutines.launch

@Composable
fun RoutineEventsPage(
    onNavigateToCreateEvent : () -> Unit,
) {

    val routineEventsViewModel = hiltViewModel<RoutineEventsViewModel>()
    val routineEvents = routineEventsViewModel.routineEvents.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    AddPage(
        onClick = onNavigateToCreateEvent,
    ) {
        HeaderPage(
            header = {
                TextHeader(
                    text = stringResource(R.string.events)
                )
            },
            topPadding = true
        ) {
            Events(
                routineEvents = routineEvents.value,
                sundayFirstDay = true,
                deleteEventOnClick = {
                    coroutineScope.launch {
                        routineEventsViewModel.delete(it)
                    }
                },
                editEventOnClick = { }
            )
        }
    }
}