package com.indigo.gymapp.routines.exercises.composable.list.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.button.radioButton.RadioButton
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.time.Rest
import com.indigo.gymapp.time.Duration
import com.indigo.gymapp.exercises.entity.ExerciseEntity
import com.indigo.gymapp.routines.exercises.RoutineExercise
import com.indigo.gymapp.routines.exercises.SetExercise
import com.indigo.gymapp.routines.exercises.TimedExercise
import com.indigo.gymapp.routines.exercises.composable.list.item.description.RoutineExerciseItemContent
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun RoutineExerciseItem(
    routineExercise: RoutineExercise,
    selectedRoutineExerciseId: Long?,
    selectOnClick: (Long) -> Unit
) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Gap.default),
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(
            selected = routineExercise.id == selectedRoutineExerciseId,
            onClick = {
                selectOnClick(routineExercise.id)
            }
        )
        RoutineExerciseItemContent(
            routineExercise = routineExercise
        )
    }

}

@Preview
@Composable
private fun SetExerciseListItemPreview() {
    HugPreview {
        RoutineExerciseItem(
            routineExercise = SetExercise(
                exercise = ExerciseEntity(name = "Chest press"),
                amountOfSets = 4,
                rest = Rest(2, 0)
            ),
            selectedRoutineExerciseId = 0,
            selectOnClick = {}
        )
    }
}

@Preview
@Composable
private fun TimedExerciseListItemPreview() {
    HugPreview {
        RoutineExerciseItem(
            routineExercise = TimedExercise(
                exercise = ExerciseEntity(name = "Running"),
                duration = Duration(30, 0)
            ),
            selectedRoutineExerciseId = 1,
            selectOnClick = {}
        )
    }
}