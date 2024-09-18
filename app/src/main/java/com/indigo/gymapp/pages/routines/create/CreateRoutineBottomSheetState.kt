package com.indigo.gymapp.pages.routines.create

sealed interface CreateRoutineBottomSheetState {
    fun showBottomSheet() : Boolean
}
data object Closed : CreateRoutineBottomSheetState {
    override fun showBottomSheet(): Boolean = false
}
sealed interface Open : CreateRoutineBottomSheetState {
    override fun showBottomSheet(): Boolean = true
}

data object NameYourRoutine : Open

data object SetRoutineRestTimeBetweenExercisesVariant : Open