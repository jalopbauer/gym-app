package com.indigo.gymapp.routines.create.exercise.create.bottomSheetContent

sealed interface CreateRoutineExerciseBottomSheetContentVariant {
    fun showBottomSheet() : Boolean
}

data object Closed : CreateRoutineExerciseBottomSheetContentVariant {
    override fun showBottomSheet(): Boolean = false
}
sealed interface Open : CreateRoutineExerciseBottomSheetContentVariant {
    override fun showBottomSheet(): Boolean = true
}

data object SelectRoutineExerciseVariant : Open

data object SelectExerciseVariant : Open