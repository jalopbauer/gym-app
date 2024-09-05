package com.indigo.gymapp.routines.create.exercise.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.bottomSheet.BottomSheet
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.common.searchBar.SearchBar
import com.indigo.gymapp.routines.create.exercise.create.bottomSheetContent.Closed
import com.indigo.gymapp.routines.create.exercise.create.bottomSheetContent.CreateRoutineExerciseBottomSheetContentVariant
import com.indigo.gymapp.routines.create.exercise.create.bottomSheetContent.SelectExerciseBottomSheetContent
import com.indigo.gymapp.routines.create.exercise.create.bottomSheetContent.SelectExerciseVariant
import com.indigo.gymapp.routines.create.exercise.create.bottomSheetContent.SelectRoutineExerciseBottomSheetContent
import com.indigo.gymapp.routines.create.exercise.create.bottomSheetContent.SelectRoutineExerciseVariant
import com.indigo.gymapp.ui.spacing.Spacing.Context


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateRoutineExercise(
    onNavigateToCreateRoutine : () -> Unit,
) {
    var addExerciseVariant by remember {
        mutableStateOf<AddExerciseVariant>(Empty)
    }

    val sheetState = rememberModalBottomSheetState()
    var bottomSheetState by remember {
        mutableStateOf<CreateRoutineExerciseBottomSheetContentVariant>(Closed)
    }

    var exerciseName by remember {
        mutableStateOf("")
    }
    Column {
        CreateHeader(
            title = stringResource(id = addExerciseVariant.titleId()),
            isSelected = addExerciseVariant.isSelected(),
            onClickDrawerButton = { bottomSheetState = SelectRoutineExerciseVariant },
            onClickSave = {
                onNavigateToCreateRoutine()
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
                    selectExerciseOnClick = { bottomSheetState = SelectExerciseVariant}
                )
                CreateTimedRoutineExercise -> CreateTimedRoutineExercise(
                    selectExerciseOnClick = { bottomSheetState = SelectExerciseVariant}
                )
                Empty -> {}
            }
        }

        BottomSheet(
            showBottomSheet = bottomSheetState.showBottomSheet(),
            onDismissRequest = { bottomSheetState = Closed },
            sheetState = sheetState
        ) {
            when (bottomSheetState) {
                SelectRoutineExerciseVariant -> {
                    SelectRoutineExerciseBottomSheetContent(
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
                    SelectExerciseBottomSheetContent(
                        exerciseName = exerciseName,
                        onQueryChange = { exerciseName = it }
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