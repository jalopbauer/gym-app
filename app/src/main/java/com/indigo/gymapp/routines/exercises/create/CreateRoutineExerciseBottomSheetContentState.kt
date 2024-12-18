package com.indigo.gymapp.routines.exercises.create

sealed interface CreateRoutineExerciseBottomSheetContentState {
    fun showBottomSheet() : Boolean
}

data object Closed : CreateRoutineExerciseBottomSheetContentState {
    override fun showBottomSheet(): Boolean = false
}
sealed interface Open : CreateRoutineExerciseBottomSheetContentState {
    override fun showBottomSheet(): Boolean = true
}

data object SelectRoutineExerciseVariant : Open

data object SelectExerciseVariant : Open

data object SetRoutineRestTimeBetweenExercisesVariant : Open

data object SetRoutineSetExerciseAmountOfSetsVariant : Open
