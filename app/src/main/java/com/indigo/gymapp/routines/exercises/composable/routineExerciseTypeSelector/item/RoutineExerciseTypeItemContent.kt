package com.indigo.gymapp.routines.exercises.composable.routineExerciseTypeSelector.item

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.indigo.gymapp.R
import com.indigo.gymapp.common.text.Small
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.common.text.headline.Headline

@Composable
fun RoutineExerciseTypeItemContent(
    routineExerciseTypeVariant : RoutineExerciseTypeVariant
) {
    Column {
        Headline(
            headline = headline(routineExerciseTypeVariant = routineExerciseTypeVariant),
            textSize = Small
        )
        Body(
            body = body(routineExerciseTypeVariant = routineExerciseTypeVariant),
            textSize = Small
        )
    }

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
