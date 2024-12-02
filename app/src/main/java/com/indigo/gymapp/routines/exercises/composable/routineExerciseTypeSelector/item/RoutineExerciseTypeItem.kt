package com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.icon.SetRoutineExercise
import com.indigo.gymapp.common.icon.TimedRoutineExercise
import com.indigo.gymapp.common.itemSelector.item.SelectorItem
import com.indigo.gymapp.common.preview.hug.HugPreview

@Composable
fun RoutineExerciseTypeItem(
    routineExerciseTypeVariant : RoutineExerciseTypeVariant,
    onClick: () -> Unit
) {
    SelectorItem(
        iconVariant = iconVariant(routineExerciseTypeVariant),
        header = headline(routineExerciseTypeVariant),
        body = body(routineExerciseTypeVariant),
        onClick = onClick
    )
}

@Composable
private fun iconVariant(routineExerciseTypeVariant: RoutineExerciseTypeVariant): IconVariant =
    when (routineExerciseTypeVariant) {
        SetExerciseVariant -> SetRoutineExercise
        TimedExerciseVariant -> TimedRoutineExercise
    }

@Composable
fun headline(routineExerciseTypeVariant : RoutineExerciseTypeVariant) : String =
    stringResource(
        when (routineExerciseTypeVariant) {
            SetExerciseVariant -> R.string.set
            TimedExerciseVariant -> R.string.timed
        }
    )

@Composable
fun body(routineExerciseTypeVariant : RoutineExerciseTypeVariant) : String =
    stringResource(
        when (routineExerciseTypeVariant) {
            SetExerciseVariant -> R.string.exercise_with_weight_for_certain_repetitions_bench_press
            TimedExerciseVariant -> R.string.exercise_that_lasts_a_specific_duration_of_time_running_planche
        }
    )


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