package com.indigo.gymapp.routines.create.exercise.create

import androidx.compose.foundation.layout.Column
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
        mutableStateOf<CreteRoutineExerciseBottomSheetState>(Closed)
    }


    Column {
        CreateHeader(
            title = stringResource(id = getTitle(addExerciseVariant)),
            isSelected = getIsSelected(addExerciseVariant),
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
                CreateSetRoutineExercise -> CreateSetRoutineExercise()
                CreateTimedRoutineExercise -> CreateTimedRoutineExercise()
                Empty -> {}
            }
        }

        BottomSheet(
            showBottomSheet = bottomSheetState.showBottomSheet(),
            onDismissRequest = { bottomSheetState = Closed },
            sheetState = sheetState
        ) {
            when (bottomSheetState) {
                SelectRoutineExerciseVariant ->
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
                Closed -> {}
            }

        }
    }
}

private fun getIsSelected(addExerciseVariant: AddExerciseVariant) =
    when (addExerciseVariant) {
        CreateSetRoutineExercise -> true
        CreateTimedRoutineExercise -> true
        Empty -> false
    }

private fun getTitle(addExerciseVariant: AddExerciseVariant) =
    when (addExerciseVariant) {
        CreateSetRoutineExercise -> R.string.set
        CreateTimedRoutineExercise -> R.string.timed
        Empty -> R.string.select_exercise_type
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

sealed interface AddExerciseVariant
data object CreateSetRoutineExercise : AddExerciseVariant
data object CreateTimedRoutineExercise : AddExerciseVariant
data object Empty : AddExerciseVariant

sealed interface CreteRoutineExerciseBottomSheetState {
    fun showBottomSheet() : Boolean
}

data object Closed : CreteRoutineExerciseBottomSheetState {
    override fun showBottomSheet(): Boolean = false
}
sealed interface Open : CreteRoutineExerciseBottomSheetState {
    override fun showBottomSheet(): Boolean = true
}

data object SelectRoutineExerciseVariant : Open