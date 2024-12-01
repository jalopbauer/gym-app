package com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.icon.SetRoutineExercise
import com.indigo.gymapp.common.icon.TimedRoutineExercise
import com.indigo.gymapp.common.icon.highlight.HighlightIcon
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun RoutineExerciseTypeItem(
    routineExerciseTypeVariant : RoutineExerciseTypeVariant,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Gap.default),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        HighlightIcon(
            iconVariant = iconVariant(routineExerciseTypeVariant)
        )
        RoutineExerciseTypeItemContent(
            routineExerciseTypeVariant = routineExerciseTypeVariant
        )
    }
}

@Composable
private fun iconVariant(routineExerciseTypeVariant: RoutineExerciseTypeVariant): IconVariant =
    when (routineExerciseTypeVariant) {
        SetExerciseVariant -> SetRoutineExercise
        TimedExerciseVariant -> TimedRoutineExercise
    }


sealed interface RoutineExerciseTypeVariant

data object SetExerciseVariant : RoutineExerciseTypeVariant

data object TimedExerciseVariant : RoutineExerciseTypeVariant

@Preview
@Composable
private fun SetRoutineExerciseTypePreview() {
    HugPreview {
        RoutineExerciseTypeItem(
            routineExerciseTypeVariant = SetExerciseVariant,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun TimedRoutineExerciseTypePreview() {
    HugPreview {
        RoutineExerciseTypeItem(
            routineExerciseTypeVariant = TimedExerciseVariant,
            onClick = {}
        )
    }
}