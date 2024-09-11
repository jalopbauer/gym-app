package com.indigo.gymapp.routines.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.bottomAppBar.CreateUpdateDeleteActionBottomAppBar
import com.indigo.gymapp.common.bottomSheet.BottomSheet
import com.indigo.gymapp.common.button.textInput.TimeAmountTextDrawerButton
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.common.textField.TextField
import com.indigo.gymapp.components.timeScrollTimeButtonsRowConfirm.TimeScrollTimeButtonsRowConfirm
import com.indigo.gymapp.routines.create.exercise.Exercise
import com.indigo.gymapp.time.Rest
import com.indigo.gymapp.ui.spacing.Spacing
import com.indigo.gymapp.ui.theme.color.Color.Context

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRoutine(
    onNavigateToRoutines: () -> Unit,
    onNavigateToAddRoutineExercise: () -> Unit
) {
    val routineViewModel = hiltViewModel<RoutineViewModel>()
    val routineExercises by routineViewModel.exercises.collectAsState()
    val routineName by routineViewModel.name.collectAsState()
    val routineRestTimeBetweenExercises by routineViewModel.restTimeBetweenExercises.collectAsState()
    val isRoutineExercisesEmpty = routineExercises.isEmpty()

    val sheetState = rememberModalBottomSheetState()

    var bottomSheetState by remember {
        mutableStateOf<CreateRoutineBottomSheetState>(Closed)
    }

    val hasWrittenRoutineName = routineName != ""
    val headerTitle = if (hasWrittenRoutineName) routineName else stringResource(id = R.string.name_your_routine)

    var minutes by remember {
        mutableIntStateOf(routineRestTimeBetweenExercises.minutes)
    }
    var seconds by remember {
        mutableIntStateOf(routineRestTimeBetweenExercises.seconds)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Context.Surface.base,
        bottomBar = {
//            TODO Remove CreateUpdateDeleteActionBottomAppBar and Scaffold from here
            CreateUpdateDeleteActionBottomAppBar(
                isDeleteEnabled = isDeleteEnabledInBottomAppBar(isRoutineExercisesEmpty),
                isEditEnabled = isEditEnabledInBottomAppBar(isRoutineExercisesEmpty),
                addOnClick = onNavigateToAddRoutineExercise,
                editOnClick = {},
                deleteOnClick = {}
            )
        },
    ) { innerPadding ->

        Column (
            modifier = Modifier.padding(innerPadding),
        ) {
            CreateHeader(
                title = headerTitle,
                isSelected = hasWrittenRoutineName,
                onClickDrawerButton = {
                    bottomSheetState = NameYourRoutine
                },
                onClickSave = {
                    onNavigateToRoutines()
                },
                onClickCancel = onNavigateToRoutines
            )
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = Spacing.Context.Padding.screen
                    ),
                verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default)
            ) {
                TimeAmountTextDrawerButton(
                    leadingText = stringResource(id = R.string.rest_between_exercises),
                    time = routineRestTimeBetweenExercises,
                    onClick = { bottomSheetState = SetRoutineRestTimeBetweenExercisesVariant }
                )
                Title(
                    title = stringResource(id = R.string.routine_exercises),
                    textSize = Large
                )
                routineExercises.forEach{
                    Exercise(
                        routineExercise = it
                    )
                }
            }
        }

        BottomSheet(
            showBottomSheet = bottomSheetState.showBottomSheet(),
            onDismissRequest = { bottomSheetState = Closed },
            sheetState = sheetState
        ) {
            when (bottomSheetState) {
                NameYourRoutine ->
                    ChangeNameBottomSheetContent(
                        routineName = routineName,
                        onValueChange = { routineViewModel.changeRoutineName(it) }
                    )
                SetRoutineRestTimeBetweenExercisesVariant -> {
                    val timButtonOnClick: (Rest) -> Unit = {
                        minutes = it.minutes
                        seconds = it.seconds
                    }
                    TimeScrollTimeButtonsRowConfirm(
                        routineRestTimeBetweenExercises = Rest(minutes, seconds),
                        selectedMinutes = { minutes = it },
                        selectedSeconds = { seconds = it },
                        leftTime = Rest(
                            minutes = 1,
                            seconds = 0
                        ),
                        leftTimeOnClick = timButtonOnClick,
                        centerTime = Rest(
                            minutes = 1,
                            seconds = 30
                        ),
                        centerTimeOnClick = timButtonOnClick,
                        rightTime = Rest(
                            minutes = 2,
                            seconds = 0
                        ),
                        rightTimeOnClick = timButtonOnClick,
                        {
                            routineViewModel.setRestTimeBetweenExercisesMinutes(minutes)
                            routineViewModel.setRestTimeBetweenExercisesSeconds(seconds)
                            bottomSheetState = Closed
                        }
                        )
                }
                Closed -> {}
            }

        }
    }
}

@Composable
private fun ChangeNameBottomSheetContent(
    routineName: String,
    onValueChange: (String) -> Unit
) {
    TextField(
// TODO Make keyboard open on show bottom sheet
// TODO close BottomSheet on keyboard enter
        value = routineName,
        label = stringResource(id = R.string.name_your_routine),
        onValueChange = onValueChange,
    )
}

private fun isDeleteEnabledInBottomAppBar(routineExercisesIsEmpty: Boolean) =
    when {
        routineExercisesIsEmpty -> false
        else -> true
    }

private fun isEditEnabledInBottomAppBar(routineExercisesIsEmpty: Boolean) =
    when {
        routineExercisesIsEmpty -> false
        else -> true
    }

@Preview
@Composable
private fun PreviewAddExerciseEmpty() {
    ScreenPreview {
        AddRoutine(
            onNavigateToRoutines = {},
            onNavigateToAddRoutineExercise = {}
        )
    }
}
