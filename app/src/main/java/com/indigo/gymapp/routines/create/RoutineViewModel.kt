package com.indigo.gymapp.routines.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.routines.create.exercise.RoutineExercise
import com.indigo.gymapp.time.Rest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor() : ViewModel() {

    private var _routineName = MutableStateFlow("")
    val routineName = _routineName.asStateFlow()

    private var _restTimeBetweenExercises = MutableStateFlow(Rest(2, 0))
    val restTimeBetweenExercises = _restTimeBetweenExercises.asStateFlow()


    fun changeRoutineName(newRoutineName: String) {
        viewModelScope.launch {
            _routineName.emit(newRoutineName)
        }
    }

    private var _routineExercises = MutableStateFlow(listOf<RoutineExercise>())
    val exercises = _routineExercises.asStateFlow()

    fun addExercise(routineExercise: RoutineExercise) {
        val newList = _routineExercises.value + routineExercise
        viewModelScope.launch {
            _routineExercises.emit(newList)
        }
    }
}