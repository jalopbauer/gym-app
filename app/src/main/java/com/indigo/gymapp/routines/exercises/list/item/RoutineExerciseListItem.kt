package com.indigo.gymapp.routines.exercises.list.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.indigo.gymapp.R
import com.indigo.gymapp.common.preview.hug.HugPreview
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.SetExercise
import com.indigo.gymapp.domain.routines.exercises.TimedExercise
import com.indigo.gymapp.domain.time.Duration
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.ui.spacing.Spacing
import com.indigo.gymapp.ui.theme.color.Color

@Composable
fun RoutineExerciseListItem(
    routineExercise: RoutineExercise
) {
    val selected = false
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
                selected = selected,
                onClick = {}
            )
            RoutineExerciseDescription(routineExercise)
        }
        Icon(
            imageVector = Icons.Outlined.Menu,
            contentDescription = stringResource(R.string.sort_item),
            tint = Color.Context.Icon.primary
        )
    }

}

@Preview
@Composable
private fun SetExerciseListItemPreview() {
    HugPreview {
        RoutineExerciseListItem(SetExercise(exerciseName = "Chest press", amountOfSets = 4, rest = Rest(2,0)))
    }
}

@Preview
@Composable
private fun TimedExerciseListItemPreview() {
    HugPreview {
        RoutineExerciseListItem(TimedExercise(exerciseName = "Running", duration = Duration(30,0)))
    }
}