package com.indigo.gymapp.exercises.local

sealed interface ExerciseBottomSheetState {
    fun showBottomSheet() : Boolean
}
data object Closed : ExerciseBottomSheetState {
    override fun showBottomSheet(): Boolean = false
}
sealed interface Open : ExerciseBottomSheetState {
    override fun showBottomSheet(): Boolean = true
}

data object DeleteExercise : Open

data object AddExercise : Open
