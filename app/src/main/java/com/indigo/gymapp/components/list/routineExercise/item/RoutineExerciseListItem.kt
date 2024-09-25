package com.indigo.gymapp.components.list.routineExercise.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.indigo.gymapp.R
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.SetExercise
import com.indigo.gymapp.domain.routines.exercises.TimedExercise
import com.indigo.gymapp.pages.routines.create.exercise.SetExerciseIconTextValue
import com.indigo.gymapp.pages.routines.create.exercise.TimedExerciseIconTextValue
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
            ExerciseDescription(routineExercise)
        }
        Icon(
            imageVector = Icons.Outlined.Menu,
            contentDescription = stringResource(R.string.sort_item),
            tint = Color.Context.Icon.primary
        )
    }

}

@Composable
private fun ExerciseDescription(routineExercise: RoutineExercise) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.space)
    ) {
        Title(title = routineExercise.exerciseName, textSize = Medium)
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.Context.Gap.default),
        ) {
            when (routineExercise) {
                is SetExercise -> SetExerciseIconTextValue(routineExercise)
                is TimedExercise -> TimedExerciseIconTextValue(routineExercise)
            }
        }
    }
}