package com.indigo.gymapp.exercise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.exercise.type.set.AddSet
import com.indigo.gymapp.exercise.type.timed.AddTimed
import com.indigo.gymapp.common.header.CreateHeader
import com.indigo.gymapp.common.preview.screen.ScreenPreview

@Composable
fun AddExercise(
    addExerciseVariant : AddExerciseVariant = Empty
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 24.dp
            )
    ) {
        CreateHeader(
            title = "Select exercise type",
        )
        when (addExerciseVariant) {
            AddSet -> AddSet()
            AddTimed -> AddTimed()
            Empty -> {}
        }
    }
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