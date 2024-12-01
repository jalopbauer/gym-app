package com.indigo.gymapp.routines.exercises.composable.list.item.description

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.indigo.gymapp.common.text.Medium
import com.indigo.gymapp.common.text.title.Title
import com.indigo.gymapp.routines.exercises.RoutineExercise
import com.indigo.gymapp.ui.number.Number.Context.Gap

@Composable
fun RoutineExerciseItemContent(routineExercise: RoutineExercise) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Gap.space)
    ) {
        Title(
            title = routineExercise.exercise.name,
            textSize = Medium
        )
        RoutineExerciseDescription(
            routineExercise = routineExercise
        )
    }
}