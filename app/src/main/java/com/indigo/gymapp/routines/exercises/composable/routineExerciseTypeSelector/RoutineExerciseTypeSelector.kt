package com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector.item.RoutineExerciseTypeItem
import com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector.item.SetExerciseVariant
import com.indigo.gymapp.ui.number.Number.Context

@Composable
fun RoutineExerciseTypeSelector(
    setRoutineExerciseOnClick: () -> Unit,
    timedRoutineExerciseOnClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        RoutineExerciseTypeItem(SetExerciseVariant, setRoutineExerciseOnClick)
//        RoutineExerciseTypeMenuItem(TimedRoutineExerciseVariant, timedRoutineExerciseOnClick)
    }
}

@Preview
@Composable
private fun SelectRoutineExerciseTypeMenuPreview() {
    HugPreview {
        RoutineExerciseTypeSelector(
            setRoutineExerciseOnClick = {},
            timedRoutineExerciseOnClick = {}
        )
    }
}