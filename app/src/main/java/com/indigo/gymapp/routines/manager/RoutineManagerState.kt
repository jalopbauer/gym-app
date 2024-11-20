package com.indigo.gymapp.routines.manager

import com.indigo.gymapp.routines.entity.RoutineEntity


sealed interface RoutineManagerState

data object CreateRoutine : RoutineManagerState

data class EditRoutine(val routineEntity: RoutineEntity) : RoutineManagerState
