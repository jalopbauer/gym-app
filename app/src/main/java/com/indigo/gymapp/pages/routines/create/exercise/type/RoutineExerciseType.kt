package com.indigo.gymapp.pages.routines.create.exercise.type

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.icon.IconVariant
import com.indigo.gymapp.common.icon.SetRoutineExercise
import com.indigo.gymapp.common.icon.TimedRoutineExercise
import com.indigo.gymapp.common.preview.screen.ScreenPreview
import com.indigo.gymapp.common.text.body.Body
import com.indigo.gymapp.common.text.headline.Headline
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun RoutineExerciseType(
    routineExerciseTypeVariant : RoutineExerciseTypeVariant,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Context.Gap.default),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
//        TODO change icon size to 32.dp
        Icon(
            iconVariant = routineExerciseTypeVariant.iconVariant
        )
        Column {
            Headline(
                headline = routineExerciseTypeVariant.headline
            )
            Body(
                body = routineExerciseTypeVariant.description
            )
        }
    }
}


sealed interface RoutineExerciseTypeVariant {
    val iconVariant: IconVariant
    val headline: String
    val description: String
}

data object SetRoutineExerciseVariant : RoutineExerciseTypeVariant {
    override val iconVariant: IconVariant = SetRoutineExercise
    override val headline: String = "Set"
    override val description: String = "Exercise with weight for certain repetitions (bench press)"
}

data object TimedRoutineExerciseVariant : RoutineExerciseTypeVariant {
    override val iconVariant: IconVariant = TimedRoutineExercise
    override val headline: String = "Timed"
    override val description: String = "Exercise that lasts a specific duration of time (running, planche)"
}



@Preview
@Composable
private fun SetRoutineExerciseTypePreview() {
    ScreenPreview {
        RoutineExerciseType(
            routineExerciseTypeVariant = SetRoutineExerciseVariant,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun TimedRoutineExerciseTypePreview() {
    ScreenPreview {
        RoutineExerciseType(
            routineExerciseTypeVariant = TimedRoutineExerciseVariant,
            onClick = {}
        )
    }
}