package com.indigo.gymapp.routines.create.exercise.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.indigo.gymapp.routines.create.exercise.type.RoutineExerciseType
import com.indigo.gymapp.routines.create.exercise.type.SetRoutineExerciseVariant
import com.indigo.gymapp.routines.create.exercise.type.TimedRoutineExerciseVariant
import com.indigo.gymapp.ui.spacing.Spacing.Context

@Composable
fun SelectRoutineExerciseBottomSheetContent(
    setRoutineExerciseOnClick: () -> Unit,
    timedRoutineExerciseOnClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Context.Gap.default)
    ) {
        RoutineExerciseType(SetRoutineExerciseVariant, setRoutineExerciseOnClick)
        RoutineExerciseType(TimedRoutineExerciseVariant, timedRoutineExerciseOnClick)
    }
}