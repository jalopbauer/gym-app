package com.indigo.gymapp.routines.manager

sealed interface SaveRoutineResult

data object Saved : SaveRoutineResult

data object MissingName : SaveRoutineResult
