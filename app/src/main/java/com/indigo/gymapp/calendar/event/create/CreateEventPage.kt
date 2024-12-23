package com.indigo.gymapp.calendar.event.create
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.calendar.event.composable.eventTypeSelector.EventTypeItemSelector
import com.indigo.gymapp.calendar.event.create.viewModel.CreateEventViewModel
import com.indigo.gymapp.calendar.event.create.viewModel.MissingRoutine
import com.indigo.gymapp.calendar.event.routine.composable.RoutineSearch
import com.indigo.gymapp.common.bottomSheet.BottomSheet
import com.indigo.gymapp.common.button.textButton.CenteredTextButton
import com.indigo.gymapp.common.daysOfTheWeek.selector.DaysOfTheWeekSelector
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.page.HeaderPage
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import kotlinx.coroutines.launch


@Composable
fun CreateEventPage(
    onNavigateToCalendar : () -> Unit,
) {
    val context = LocalContext.current

    var createEventVariant by remember {
        mutableStateOf<CreateEventVariant>(CreateRoutineEvent)
    }

    var bottomSheetState by remember {
        mutableStateOf(if(createEventVariant is Empty) SelectEventVariant else Closed)
    }

    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()
    val createEventViewModel = hiltViewModel<CreateEventViewModel>()

    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setEmpty()
    }

    val searchRoutines by createEventViewModel.routines.collectAsState()

    var routineSearchText by remember {
        mutableStateOf("")
    }

    LaunchedEffect(routineSearchText) {
        createEventViewModel.searchRoutine(routineSearchText)
    }

    val selectedRoutine by createEventViewModel.selectedRoutine.collectAsState()
    val selectedDaysOfTheWeek by createEventViewModel.selectedDaysOfTheWeek.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    HeaderPage(
        header = {
            CreateHeader(
                text = stringResource(id = createEventVariant.titleId()),
                selected = createEventVariant.isSelected(),
                onClickTextButton = { bottomSheetState = SelectEventVariant },
                onClickSave = {
                    when (createEventVariant) {
                        Empty -> Toast.makeText(context, context.getString(R.string.must_select_event_type), Toast.LENGTH_SHORT).show()
                        CreateRoutineEvent -> {
                            coroutineScope.launch {
                                createEventViewModel.createRoutineEvent()
                                    .onFailure { error ->
                                        when {
                                            error is MissingRoutine -> Toast.makeText(context, context.getString(R.string.must_select_routine), Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                    .onSuccess {
                                        Toast.makeText(context, context.getString(R.string.event_created), Toast.LENGTH_SHORT).show()
                                        onNavigateToCalendar()
                                    }
                            }
                        }
                    }
                },
                onClickCancel = {
                    onNavigateToCalendar()
                },
            )
        }
    ) {
        when (createEventVariant) {
            CreateRoutineEvent -> {
                CenteredTextButton(
                    text = selectedRoutine?.name ?: stringResource(R.string.select_routine),
                    selected = selectedRoutine != null,
                    onClick = {
                        bottomSheetState = SelectRoutineVariant
                    }
                )
                DaysOfTheWeekSelector(
                    sundayFirstDay = false,
                    selectedDayOfTheWeek = selectedDaysOfTheWeek,
                    getDayOnClick = {
                        createEventViewModel.setSelectedDayOfTheWeek(it)
                    }
                )

            }
            Empty -> {}
        }
    }

    BottomSheet(
        showBottomSheet = bottomSheetState.showBottomSheet(),
        onDismissRequest = { bottomSheetState = Closed },
    ) {
        when (bottomSheetState) {
            SelectEventVariant -> {
                EventTypeItemSelector(
                    setRoutineOnClick = {
                        createEventVariant = CreateRoutineEvent
                        bottomSheetState = Closed
                    }
                )
            }
            SelectRoutineVariant -> {
                RoutineSearch(
                    routineName = routineSearchText,
                    routines = searchRoutines,
                    onQueryChange = { routineSearchText = it },
                    getRoutineOnClick = {
                        createEventViewModel.setSelectedRoutine(it)
                        bottomSheetState = Closed
                    }
                )
            }
            Closed -> {}
        }
    }
}

sealed interface CreateEventVariant {
    fun titleId() : Int
    fun isSelected(): Boolean
}

data object Empty : CreateEventVariant {
    override fun titleId(): Int = R.string.select_event_type
    override fun isSelected() : Boolean = false
}

sealed interface SelectedCreateEventVariant : CreateEventVariant {
    override fun isSelected(): Boolean = true

}

data object CreateRoutineEvent : SelectedCreateEventVariant {
    override fun titleId(): Int = R.string.routine
}