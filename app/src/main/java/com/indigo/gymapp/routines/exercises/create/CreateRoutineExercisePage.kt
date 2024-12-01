package com.indigo.gymapp.routines.exercises.create

import android.widget.Toast
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
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.routines.exercises.create.composable.HorizontalScrollConfirm
import com.indigo.gymapp.time.Rest
import com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector.RoutineExerciseTypeSelector
import com.indigo.gymapp.common.restSelector.RestSelector
import com.indigo.gymapp.exercises.viewModel.ExerciseViewModel
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarViewModel
import com.indigo.gymapp.routines.exercises.SetExercise
import com.indigo.gymapp.routines.exercises.create.composable.exerciseSearch.ExerciseSearch
import com.indigo.gymapp.routines.manager.RoutineViewModel
import com.indigo.gymapp.ui.number.Number.Context
import kotlinx.coroutines.launch


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

    var amountOfSets by remember {
        mutableIntStateOf(routineExerciseBuilder.amountOfSets)
    }

    val exerciseViewModel = hiltViewModel<ExerciseViewModel>()
    val searchExercises by exerciseViewModel.searchExercises.collectAsState()
    val exerciseSearchText by exerciseViewModel.exerciseSearchText.collectAsState()

    var addExerciseVariant by remember {
        mutableStateOf<AddExerciseVariant>(Empty)
    }

    var bottomSheetState by remember {
        mutableStateOf(if(addExerciseVariant is Empty) SelectRoutineExerciseVariant else Closed)
    }

    val bottomAppBarViewModel = hiltViewModel<BottomAppBarViewModel>()

    LaunchedEffect(Unit) {
        exerciseViewModel.searchExercise("")
        bottomAppBarViewModel.setEmpty()
        routineViewModel.setInitialRoutineExerciseBuilder()
    }

    val coroutineScope = rememberCoroutineScope()
    Column {
        CreateHeader(
            text = stringResource(id = addExerciseVariant.titleId()),
            selected = addExerciseVariant.isSelected(),
            onClickTextButton = { bottomSheetState = SelectRoutineExerciseVariant },
            onClickSave = {
                when (addExerciseVariant) {
                    Empty -> Toast.makeText(context, context.getString(R.string.must_select_exercise_type), Toast.LENGTH_SHORT).show()
                    CreateSetRoutineExercise -> {
                        routineExerciseBuilder.exercise?.let {
                            val routineExercise = SetExercise(
                                exercise = it,
                                amountOfSets = routineExerciseBuilder.amountOfSets,
                                rest = routineExerciseBuilder.rest
                            )
                            coroutineScope.launch {
                                routineViewModel.addExercise(routineExercise)
                            }
                            onNavigateToCreateRoutine()
                            routineViewModel.setInitialRoutineExerciseBuilder()
                            Toast.makeText(context, context.getString(R.string.routine_exercise_created), Toast.LENGTH_SHORT).show()
                        } ?: Toast.makeText(context, context.getString(R.string.must_select_exercise), Toast.LENGTH_SHORT).show()
                    }
                    CreateTimedRoutineExercise -> TODO()
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
                    amountOfSets = routineExerciseBuilder.amountOfSets,
                    setRestTimeOnClick = { bottomSheetState = SetRoutineRestTimeBetweenExercisesVariant },
                    setAmountOfSetsOnClick = { bottomSheetState = SetRoutineSetExerciseAmountOfSetsVariant }
                )
                CreateTimedRoutineExercise -> CreateTimedRoutineExercise(
                    exercise = routineExerciseBuilder.exercise,
                    selectExerciseOnClick = { bottomSheetState = SelectExerciseVariant }
                )
                Empty -> {}
            }
        }

        BottomSheet(
            showBottomSheet = bottomSheetState.showBottomSheet(),
            onDismissRequest = { bottomSheetState = Closed },
        ) {
            when (bottomSheetState) {
                SelectRoutineExerciseVariant -> {
                    RoutineExerciseTypeSelector(
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
                    RestSelector(
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
                            routineViewModel.setRoutineExerciseBuilderRest(Rest(minutes = minutes, seconds = seconds))
                            bottomSheetState = Closed
                        }
                    )
                }
                SetRoutineSetExerciseAmountOfSetsVariant -> {
                    HorizontalScrollConfirm(
                        initialPage = routineExerciseBuilder.amountOfSets,
                        selectedItem = { amountOfSets = it },
                        onClick = {
                            routineViewModel.setRoutineExerciseBuilderAmountOfSets(amountOfSets)
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