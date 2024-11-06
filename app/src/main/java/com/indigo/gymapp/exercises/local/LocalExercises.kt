package com.indigo.gymapp.exercises.local

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.bottomSheet.BottomSheet
import com.indigo.gymapp.common.button.Button
import com.indigo.gymapp.common.button.Danger
import com.indigo.gymapp.common.button.Secondary
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.common.textField.TextField
import com.indigo.gymapp.exercises.Exercise
import com.indigo.gymapp.exercises.viewModel.ExerciseViewModel
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun LocalExercises() {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    val exerciseViewModel = hiltViewModel<ExerciseViewModel>()
    val exercises by exerciseViewModel.exercises.collectAsState(initial = emptyList())
    var newExerciseName by remember {
        mutableStateOf("")
    }

    var selectedExerciseId by remember {
        mutableStateOf<Long?>(null)
    }

    var bottomSheetState by remember {
        mutableStateOf<ExerciseBottomSheetState>(Closed)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { focusManager.clearFocus() },
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        NewExerciseNameTextField(
            newExerciseName = newExerciseName,
            onValueChange = { newExerciseName = it }
        )
        AddExerciseButton(
            onClick = {
                exerciseViewModel.createExercise(newExerciseName)
                Toast.makeText(
                    context,
                    context.getString(R.string.exercise_added, newExerciseName),
                    Toast.LENGTH_SHORT
                ).show()
                newExerciseName = ""
                focusManager.clearFocus()
            }
        )
        Exercises(
            exercises = exercises,
            deleteOnClick = {
                bottomSheetState = DeleteExercise
                selectedExerciseId = it
            }
        )
    }
    BottomSheet(
        showBottomSheet = bottomSheetState.showBottomSheet(),
        onDismissRequest = {
            selectedExerciseId = null
            bottomSheetState = Closed
        },
    ) {
        when (bottomSheetState) {
            DeleteExercise -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(Context.Gap.medium)
                ) {
                    Headline(headline = stringResource(R.string.deleting_this_exercise_will_delete_all_exercises_in_your_routines))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(Context.Gap.default)
                    ) {
                        Button(
                            text = stringResource(R.string.cancel),
                            onClick = {
                                selectedExerciseId = null
                                bottomSheetState = Closed
                            },
                            modifier = Modifier.weight(1f),
                            buttonVariant = Secondary
                        )
                        Button(
                            text = stringResource(R.string.delete),
                            onClick = {
                                selectedExerciseId?.let {
                                    exerciseViewModel.deleteExercise(it)
                                }
                                bottomSheetState = Closed
                                Toast.makeText(context, context.getString(R.string.exercise_deleted), Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.weight(1f),
                            buttonVariant = Danger
                        )
                    }
                }
            }
            Closed -> {}
        }
    }
}

@Composable
private fun Exercises(exercises: List<Exercise>, deleteOnClick: (Long) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = Context.Gap.default)
    ) {
        items(exercises) { exercise ->
            Exercise(
                exercise = exercise,
                deleteOnClick = deleteOnClick
            )
        }
    }
}

@Composable
private fun AddExerciseButton(onClick: () -> Unit) {
    Button(
        text = stringResource(R.string.add_exercise),
        onClick = onClick
    )
}

@Composable
private fun NewExerciseNameTextField(
    newExerciseName: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = newExerciseName,
        label = stringResource(R.string.exercise_name),
        onValueChange = onValueChange
    )
}