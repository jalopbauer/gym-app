package com.indigo.gymapp.routines

sealed interface RoutineBottomSheetState {
    fun showBottomSheet() : Boolean
}
data object Closed : RoutineBottomSheetState {
    override fun showBottomSheet(): Boolean = false
}
sealed interface Open : RoutineBottomSheetState {
    override fun showBottomSheet(): Boolean = true
}

data object DeleteRoutine : Open