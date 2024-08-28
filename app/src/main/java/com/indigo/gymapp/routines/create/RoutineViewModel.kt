package com.indigo.gymapp.routines.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.routines.create.exercise.RoutineExercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor() : ViewModel() {

    private var _routineExercises = MutableStateFlow(listOf<RoutineExercise>())
    val exercises = _routineExercises.asStateFlow()

    fun addExercise(routineExercise: RoutineExercise) {
        val newList = _routineExercises.value + routineExercise
        viewModelScope.launch {
            _routineExercises.emit(newList)
        }
    }
}