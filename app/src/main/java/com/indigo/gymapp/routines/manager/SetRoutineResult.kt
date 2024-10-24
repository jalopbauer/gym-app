package com.indigo.gymapp.routines.manager

sealed interface SetRoutineResult

data object RoutineFound : SetRoutineResult

data object RoutineNotFound : SetRoutineResult
