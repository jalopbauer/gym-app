package com.indigo.gymapp.common.icon.highlight

import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.icon.Icon
import com.indigo.gymapp.common.selectRoutineExerciseType.item.RoutineExerciseTypeVariant
import com.indigo.gymapp.ui.spacing.Spacing.Component.Icon.Highlight

@Composable
fun HighlightIcon(routineExerciseTypeVariant: RoutineExerciseTypeVariant) {
    Icon(
        iconVariant = routineExerciseTypeVariant.iconVariant,
        size = Highlight.size
    )
}