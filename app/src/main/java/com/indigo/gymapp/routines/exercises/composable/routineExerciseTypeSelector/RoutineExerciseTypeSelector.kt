package com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.itemSelector.ItemSelector
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector.item.RoutineExerciseTypeItem
import com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector.item.SetExerciseVariant
import com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector.item.TimedExerciseVariant

@Composable
fun RoutineExerciseTypeSelector(
    setRoutineExerciseOnClick: () -> Unit,
    timedRoutineExerciseOnClick: () -> Unit
) {
    ItemSelector {
        RoutineExerciseTypeItem(SetExerciseVariant, setRoutineExerciseOnClick)
        RoutineExerciseTypeItem(TimedExerciseVariant, timedRoutineExerciseOnClick)
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