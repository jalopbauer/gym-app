package com.indigo.gymapp.exercises

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.bottomSheet.BottomSheet
import com.indigo.gymapp.common.button.floatingActionButton.FloatingActionButton
import com.indigo.gymapp.common.icon.Add
import com.indigo.gymapp.common.text.Large
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.exercises.composable.AddExercise
import com.indigo.gymapp.exercises.composable.DeleteExercise
import com.indigo.gymapp.exercises.composable.Exercises
import com.indigo.gymapp.exercises.viewModel.ExerciseViewModel
import com.indigo.gymapp.ui.spacing.Spacing.Context
import com.indigo.gymapp.ui.spacing.Spacing.Context.Padding
import kotlinx.coroutines.launch


@Composable
fun ExercisesPage() {
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

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable { focusManager.clearFocus() }
                .padding(horizontal = Padding.screen),
            verticalArrangement = Arrangement.spacedBy(Context.Gap.default)

        ) {
            Headline(
                headline = stringResource(R.string.exercises),
                textSize = Large
            )
            Exercises(
                exercises = exercises,
                deleteOnClick = {
                    bottomSheetState = DeleteExercise
                    selectedExerciseId = it
                }
            )
        }

        FloatingActionButton(
            iconVariant = Add,
            onClick = {
                bottomSheetState = AddExercise
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(Padding.button)
        )
    }


    val dismissRequest = {
        selectedExerciseId = null
        bottomSheetState = Closed
    }
    BottomSheet(
        showBottomSheet = bottomSheetState.showBottomSheet(),
        onDismissRequest = dismissRequest,
    ) {
        when (bottomSheetState) {
            DeleteExercise -> {
                DeleteExercise(
                    cancelOnClick = dismissRequest,
                    deleteOnClick = {
                        selectedExerciseId?.let {
                            exerciseViewModel.deleteExercise(it)
                        }
                        dismissRequest()
                        Toast.makeText(
                            context,
                            context.getString(R.string.exercise_deleted),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
            AddExercise -> {
                AddExercise(
                    newExerciseName = newExerciseName,
                    onExerciseNameChange = { newExerciseName = it },
                    addExerciseOnClick = {
                        if (newExerciseName == "") {
                            Toast.makeText(
                                context,
                                context.getString(R.string.cannot_create_empty_name_exercise),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            coroutineScope.launch {
                                exerciseViewModel.createExercise(newExerciseName)
                                    .onSuccess {
                                        Toast.makeText(
                                            context,
                                            context.getString(R.string.exercise_added, newExerciseName),
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        newExerciseName = ""
                                        focusManager.clearFocus()
                                        bottomSheetState = Closed
                                    }.onFailure { _ ->
                                        Toast.makeText(context, context.getString(R.string.cannot_save_exercise_with_same_name), Toast.LENGTH_SHORT).show()
                                    }
                            }

                        }
                    }
                )
            }
            Closed -> {}
        }
    }
}