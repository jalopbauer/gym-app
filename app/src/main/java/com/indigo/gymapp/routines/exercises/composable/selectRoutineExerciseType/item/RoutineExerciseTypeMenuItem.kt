package com.indigo.gymapp.routines.exercises.composable.selectRoutineExerciseType.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.icon.SetRoutineExercise
import com.indigo.gymapp.common.icon.TimedRoutineExercise
import com.indigo.gymapp.common.icon.highlight.HighlightIcon
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.number.Number.Context

@Composable
fun RoutineExerciseTypeMenuItem(
    routineExerciseTypeVariant : RoutineExerciseTypeVariant,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Context.Gap.default),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        HighlightIcon(
            iconVariant = routineExerciseTypeVariant.iconVariant
        )
        Column {
            Headline(
                headline = stringResource(routineExerciseTypeVariant.headline)
            )
            Body(
                body = stringResource(routineExerciseTypeVariant.description)
            )
        }
    }
}


sealed interface RoutineExerciseTypeVariant {
    val iconVariant: IconVariant
    val headline: Int
    val description: Int
}

data object SetRoutineExerciseVariant : RoutineExerciseTypeVariant {
    override val iconVariant: IconVariant = SetRoutineExercise
    override val headline = R.string.set
    override val description = R.string.exercise_with_weight_for_certain_repetitions_bench_press
}

data object TimedRoutineExerciseVariant : RoutineExerciseTypeVariant {
    override val iconVariant: IconVariant = TimedRoutineExercise
    override val headline = R.string.timed
    override val description = R.string.exercise_that_lasts_a_specific_duration_of_time_running_planche
}



@Preview
@Composable
private fun SetRoutineExerciseTypePreview() {
    HugPreview {
        RoutineExerciseTypeMenuItem(
            routineExerciseTypeVariant = SetRoutineExerciseVariant,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun TimedRoutineExerciseTypePreview() {
    HugPreview {
        RoutineExerciseTypeMenuItem(
            routineExerciseTypeVariant = TimedRoutineExerciseVariant,
            onClick = {}
        )
    }
}