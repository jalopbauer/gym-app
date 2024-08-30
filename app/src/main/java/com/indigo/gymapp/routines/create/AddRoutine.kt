package com.indigo.gymapp.routines.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.bottomSheet.BottomSheet
import com.indigo.gymapp.common.button.textInput.TimeAmountTextDrawerButton
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.common.textField.CustomTextField
import com.indigo.gymapp.routines.create.exercise.Exercise
import com.indigo.gymapp.time.Rest
import com.indigo.gymapp.ui.spacing.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRoutine(onNavigateToRoutines: () -> Unit) {
    
    val routineViewModel = hiltViewModel<RoutineViewModel>()
    val routineExercises by routineViewModel.exercises.collectAsState()
    val routineName by routineViewModel.routineName.collectAsState()

    val hastWrittenRoutineName = routineName != ""

    val sheetState = rememberModalBottomSheetState()

    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    val title = stringResource(id = R.string.name_your_routine)
    Column {
        CreateHeader(
            title = if(hastWrittenRoutineName) routineName else title,
            isSelected = hastWrittenRoutineName,
            onClickDrawerButton = {
                showBottomSheet = true
            },
            onClickSave = {
                onNavigateToRoutines()
            },
            onClickCancel = {
                onNavigateToRoutines()
            },
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
                time = Rest(2, 0),
                onClick = {}
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
        showBottomSheet = showBottomSheet,
        onDismissRequest = { showBottomSheet = false },
        sheetState = sheetState
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CustomTextField(
//                TODO Make keyboard open on show bottom sheet
                value = routineName,
                label = title,
                onValueChange = { routineViewModel.changeRoutineName(it) },
            )

        }
    }
}

@Preview
@Composable
private fun PreviewAddExerciseEmpty() {
    ScreenPreview {
        AddRoutine {}
    }
}
