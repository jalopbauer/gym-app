package com.indigo.gymapp.routines.exercises.create

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigo.gymapp.R
import com.indigo.gymapp.common.bottomSheet.BottomSheet
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.components.menu.selectRoutineExerciseType.SelectRoutineExerciseTypeMenu
import com.indigo.gymapp.components.timeScrollTimeButtonsRowConfirm.TimeScrollTimeButtonsRowConfirm
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.exercises.viewModel.ExerciseViewModel
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import com.indigo.gymapp.routines.exercises.create.exerciseSearch.ExerciseSearch
import com.indigo.gymapp.routines.manager.RoutineViewModel
import com.indigo.gymapp.ui.spacing.Spacing.Context


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateRoutineExercise(
    onNavigateToCreateRoutine : () -> Unit,
) {
    val context = LocalContext.current
    val routineViewModel = hiltViewModel<RoutineViewModel>()
    val routineExerciseBuilder by routineViewModel.routineExerciseBuilder.collectAsState()

    var minutes by remember {
        mutableIntStateOf(routineExerciseBuilder.rest.minutes)
    }
    var seconds by remember {
        mutableIntStateOf(routineExerciseBuilder.rest.seconds)
    }

    val exerciseViewModel = hiltViewModel<ExerciseViewModel>()
    val searchExercises by exerciseViewModel.searchExercises.collectAsState()
    val exerciseSearchText by exerciseViewModel.exerciseSearchText.collectAsState()
    LaunchedEffect(Unit) {
        exerciseViewModel.searchExercise("")
    }
    var addExerciseVariant by remember {
        mutableStateOf<AddExerciseVariant>(Empty)
    }

    val sheetState = rememberModalBottomSheetState()
    var bottomSheetState by remember {
        mutableStateOf<CreateRoutineExerciseBottomSheetContentState>(Closed)
    }

    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()

    LaunchedEffect(Unit) {
        bottomAppBarViewModel.setEmpty()
    }

    Column {
        CreateHeader(
            title = stringResource(id = addExerciseVariant.titleId()),
            isSelected = addExerciseVariant.isSelected(),
            onClickDrawerButton = { bottomSheetState = SelectRoutineExerciseVariant },
            onClickSave = {
                when {
                    addExerciseVariant is Empty -> Toast.makeText(context,
                        context.getString(R.string.must_select_exercise_type), Toast.LENGTH_SHORT).show()
                    routineExerciseBuilder.exercise == null -> Toast.makeText(context,
                        context.getString(
                            R.string.must_select_exercise
                        ), Toast.LENGTH_SHORT).show()
                    else -> onNavigateToCreateRoutine()
                }
            },
            onClickCancel = {
                onNavigateToCreateRoutine()
            },
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = Context.Padding.screen
                )
        ) {
            when (addExerciseVariant) {
                CreateSetRoutineExercise -> CreateSetRoutineExercise(
                    selectExerciseOnClick = { bottomSheetState = SelectExerciseVariant },
                    exercise = routineExerciseBuilder.exercise,
                    rest = routineExerciseBuilder.rest,
                    amountOfSets = 4,
                    setRestTimeOnClick = { bottomSheetState = SetRoutineRestTimeBetweenExercisesVariant }
                )
                CreateTimedRoutineExercise -> CreateTimedRoutineExercise(
                    selectExerciseOnClick = { bottomSheetState = SelectExerciseVariant }
                )
                Empty -> {}
            }
        }

        BottomSheet(
            showBottomSheet = bottomSheetState.showBottomSheet(),
            onDismissRequest = { bottomSheetState = Closed },
            sheetState = sheetState,
        ) {
            when (bottomSheetState) {
                SelectRoutineExerciseVariant -> {
                    SelectRoutineExerciseTypeMenu(
                        setRoutineExerciseOnClick = {
                            addExerciseVariant = CreateSetRoutineExercise
                            bottomSheetState = Closed
                        },
                        timedRoutineExerciseOnClick = {
                            addExerciseVariant = CreateTimedRoutineExercise
                            bottomSheetState = Closed
                        }
                    )
                }
                SelectExerciseVariant -> {
                    ExerciseSearch(
                        exerciseName = exerciseSearchText,
                        exercises = searchExercises,
                        onQueryChange = { exerciseViewModel.searchExercise(it) },
                        getExerciseOnClick = {
                            routineViewModel.setRoutineExerciseBuilderExercise(it)
                            bottomSheetState = Closed
                        }
                    )
                }
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
                        {
                            routineViewModel.setRoutineExerciseBuilderRestMinutes(minutes)
                            routineViewModel.setRoutineExerciseBuilderRestSeconds(seconds)
                            bottomSheetState = Closed
                        }
                    )
                }
                Closed -> {}
            }

        }
    }
}
@Preview
@Composable
private fun PreviewAddExerciseEmpty() {
    ScreenPreview {
        CreateRoutineExercise(
            onNavigateToCreateRoutine = {}
        )
    }
}

sealed interface AddExerciseVariant {
    fun titleId() : Int
    fun isSelected(): Boolean
}

data object Empty : AddExerciseVariant {
    override fun titleId(): Int = R.string.select_exercise_type
    override fun isSelected() : Boolean = false
}

sealed interface SelectedAddExerciseVariant : AddExerciseVariant {
    override fun isSelected(): Boolean = true

}

data object CreateSetRoutineExercise : SelectedAddExerciseVariant {
    override fun titleId(): Int = R.string.set
}

data object CreateTimedRoutineExercise : SelectedAddExerciseVariant {
    override fun titleId(): Int = R.string.timed
}