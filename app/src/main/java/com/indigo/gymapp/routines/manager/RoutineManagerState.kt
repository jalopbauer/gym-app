package com.indigo.gymapp.routines.manager

sealed interface RoutineManagerState

data object CreateRoutine : RoutineManagerState

data class EditRoutine(val routineId: Long) : RoutineManagerState
