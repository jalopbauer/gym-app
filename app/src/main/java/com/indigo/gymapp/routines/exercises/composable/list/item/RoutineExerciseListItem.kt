package com.indigo.gymapp.routines.exercises.composable.list.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.common.radioButton.RadioButton
import com.indigo.gymapp.exercises.entity.ExerciseEntity
import com.indigo.gymapp.routines.exercises.RoutineExercise
import com.indigo.gymapp.routines.exercises.SetExercise
import com.indigo.gymapp.routines.exercises.TimedExercise
import com.indigo.gymapp.ui.spacing.Spacing

@Composable
fun RoutineExerciseListItem(
    routineExercise: RoutineExercise,
    selectedRoutineExerciseId: Long?,
    selectOnClick: (Long) -> Unit
) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = routineExercise.id == selectedRoutineExerciseId,
                onClick = {
                    selectOnClick(routineExercise.id)
                }
            )
            RoutineExerciseDescription(routineExercise)
        }
//        Icon(
//            imageVector = Icons.Outlined.Menu,
//            contentDescription = stringResource(R.string.sort_item),
//            tint = Color.Context.Icon.primary
//        )
    }

}

@Preview
@Composable
private fun SetExerciseListItemPreview() {
    HugPreview {
        RoutineExerciseListItem(
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
        RoutineExerciseListItem(
            routineExercise = TimedExercise(
                exercise = ExerciseEntity(name = "Running"),
                duration = Duration(30, 0)
            ),
            selectedRoutineExerciseId = 1,
            selectOnClick = {}
        )
    }
}