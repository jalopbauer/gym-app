package com.indigo.gymapp.addRoutine.addExercise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.addRoutine.addExercise.type.set.AddSet
import com.indigo.gymapp.addRoutine.addExercise.type.timed.AddTimed
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun AddExercise(
    addExerciseVariant : AddExerciseVariant = Empty
) {
    val title = stringResource(id = getTitle(addExerciseVariant))
    val isSelected = getIsSelected(addExerciseVariant)
    Column {
        CreateHeader(
            title = title,
            isSelected = isSelected
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = Spacing.Context.Padding.screen
                )
        ) {
            when (addExerciseVariant) {
                AddSet -> AddSet()
                AddTimed -> AddTimed()
                Empty -> {}
            }
        }
    }
}

private fun getIsSelected(addExerciseVariant: AddExerciseVariant) =
    when (addExerciseVariant) {
        AddSet -> true
        AddTimed -> true
        Empty -> false
    }

private fun getTitle(addExerciseVariant: AddExerciseVariant) =
    when (addExerciseVariant) {
        AddSet -> R.string.set
        AddTimed -> R.string.timed
        Empty -> R.string.select_exercise_type
    }

@Preview
@Composable
private fun PreviewAddExerciseEmpty() {
    ScreenPreview {
        AddExercise()
    }
}

@Preview
@Composable
private fun PreviewAddESet() {
    ScreenPreview {
        AddExercise(
            addExerciseVariant = AddSet
        )
    }
}

@Preview
@Composable
private fun PreviewAddTimed() {
    ScreenPreview {
        AddExercise(
            addExerciseVariant = AddTimed
        )
    }
}

sealed interface AddExerciseVariant
data object AddSet : AddExerciseVariant
data object AddTimed : AddExerciseVariant
data object Empty : AddExerciseVariant