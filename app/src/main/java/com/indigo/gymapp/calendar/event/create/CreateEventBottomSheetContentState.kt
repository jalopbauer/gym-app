package com.indigo.gymapp.calendar.event.create

sealed interface CreateEventBottomSheetContentState {
    fun showBottomSheet() : Boolean
}

data object Closed : CreateEventBottomSheetContentState {
    override fun showBottomSheet(): Boolean = false
}

sealed interface Open : CreateEventBottomSheetContentState {
    override fun showBottomSheet(): Boolean = true
}

data object SelectEventVariant : Open

data object SelectRoutineVariant : Open