package com.indigo.gymapp.common.icon.highlight

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.components.menu.selectRoutineExerciseType.item.RoutineExerciseTypeVariant

@Composable
fun HighlightIcon(routineExerciseTypeVariant: RoutineExerciseTypeVariant) {
    Icon(
        iconVariant = routineExerciseTypeVariant.iconVariant,
        size = 32.dp
    )
}