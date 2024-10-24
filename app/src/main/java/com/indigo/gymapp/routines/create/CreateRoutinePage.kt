package com.indigo.gymapp.routines.create

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.bottomSheet.BottomSheet
import com.indigo.gymapp.common.button.textInput.TimeAmountTextDrawerButton
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.common.textField.TextField
import com.indigo.gymapp.components.timeScrollTimeButtonsRowConfirm.TimeScrollTimeButtonsRowConfirm
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import com.indigo.gymapp.routines.exercises.list.RoutineExerciseList
import com.indigo.gymapp.routines.manager.MissingName
import com.indigo.gymapp.routines.manager.RoutineViewModel
import com.indigo.gymapp.routines.manager.Saved
import com.indigo.gymapp.ui.spacing.Spacing
import kotlinx.coroutines.launch

@Composable
fun CreateRoutine(
    onNavigateToRoutines: () -> Unit,
    onNavigateToAddRoutineExercise: () -> Unit
) {
    val context = LocalContext.current

    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()


    val routineViewModel = hiltViewModel<RoutineViewModel>()
    val routineExercises by routineViewModel.exercises.collectAsState()
    val savedRoutineName by routineViewModel.name.collectAsState()
    val routineRestTimeBetweenExercises by routineViewModel.restTimeBetweenExercises.collectAsState()
    val isRoutineExercisesEmpty = routineExercises.isEmpty()

    var routineName by remember {
        mutableStateOf(savedRoutineName)
    }

    val hasWrittenRoutineName = routineName != ""
    val headerTitle = if (hasWrittenRoutineName) routineName else stringResource(id = R.string.name_your_routine)

    var bottomSheetState by remember {
        mutableStateOf(if (hasWrittenRoutineName) Closed else NameYourRoutine)
    }
    var minutes by remember {
        mutableIntStateOf(routineRestTimeBetweenExercises.minutes)
    }
    var seconds by remember {
        mutableIntStateOf(routineRestTimeBetweenExercises.seconds)
    }

    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setCreateUpdateDelete(
            isDeleteEnabled = isDeleteEnabledInBottomAppBar(isRoutineExercisesEmpty),
            isEditEnabled = isEditEnabledInBottomAppBar(isRoutineExercisesEmpty),
            addOnClick = onNavigateToAddRoutineExercise,
            editOnClick = {},
            deleteOnClick = {}
        )
    }
    val coroutineScope = rememberCoroutineScope()

    Column {
        CreateHeader(
            title = headerTitle,
            isSelected = hasWrittenRoutineName,
            onClickDrawerButton = {
                bottomSheetState = NameYourRoutine
            },
            onClickSave = {
                coroutineScope.launch {
                    routineViewModel.changeRoutineName(routineName)
                    when (routineViewModel.saveRoutine()) {
                        MissingName -> Toast.makeText(context, context.getString(R.string.must_have_name_set), Toast.LENGTH_SHORT).show()
                        Saved -> onNavigateToRoutines()
                    }
                }
            },
            onClickCancel = {
                onNavigateToRoutines()
            }
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
            RoutineExerciseList(routineExercises)
        }
    }

    BottomSheet(
        showBottomSheet = bottomSheetState.showBottomSheet(),
        onDismissRequest = { bottomSheetState = Closed },
    ) {
        when (bottomSheetState) {
            NameYourRoutine ->
                ChangeNameBottomSheetContent(
                    routineName = routineName,
                    onValueChange = { routineName = it }
                )
            SetRoutineRestTimeBetweenExercisesVariant -> {
                TimeScrollTimeButtonsRowConfirm(
                    routineRestTimeBetweenExercises = Rest(minutes, seconds),
                    selectedMinutes = { minutes = it },
                    selectedSeconds = { seconds = it },
                    leftTime = Rest(
                        minutes = 1,
                        seconds = 0
                    ),
                    centerTime = Rest(
                        minutes = 1,
                        seconds = 30
                    ),
                    rightTime = Rest(
                        minutes = 2,
                        seconds = 0
                    ),
                    confirmOnClick = {
                        coroutineScope.launch {
                            routineViewModel.setRestTimeBetweenExercises(newRest = Rest(minutes = minutes, seconds = seconds))
                        }
                        bottomSheetState = Closed
                    }
                )
            }
            Closed -> {}
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
        CreateRoutine(
            onNavigateToRoutines = {},
            onNavigateToAddRoutineExercise = {}
        )
    }
}
