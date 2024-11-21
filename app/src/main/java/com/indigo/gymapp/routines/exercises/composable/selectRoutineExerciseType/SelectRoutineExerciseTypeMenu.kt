package com.indigo.gymapp.routines.exercises.composable.selectRoutineExerciseType

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.routines.exercises.composable.selectRoutineExerciseType.item.RoutineExerciseTypeMenuItem
import com.indigo.gymapp.routines.exercises.composable.selectRoutineExerciseType.item.SetRoutineExerciseVariant
import com.indigo.gymapp.ui.number.Number.Context

@Composable
fun SelectRoutineExerciseTypeMenu(
    setRoutineExerciseOnClick: () -> Unit,
    timedRoutineExerciseOnClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        RoutineExerciseTypeMenuItem(SetRoutineExerciseVariant, setRoutineExerciseOnClick)
//        RoutineExerciseTypeMenuItem(TimedRoutineExerciseVariant, timedRoutineExerciseOnClick)
    }
}

@Preview
@Composable
private fun SelectRoutineExerciseTypeMenuPreview() {
    HugPreview {
        SelectRoutineExerciseTypeMenu(
            setRoutineExerciseOnClick = {},
            timedRoutineExerciseOnClick = {}
        )
    }
}