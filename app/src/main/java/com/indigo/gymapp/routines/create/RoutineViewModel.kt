package com.indigo.gymapp.routines.create

import androidx.annotation.IntRange
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

    private var _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private var _restTimeBetweenExercises = MutableStateFlow(Rest(2, 0))
    val restTimeBetweenExercises = _restTimeBetweenExercises.asStateFlow()

    fun setRestTimeBetweenExercisesSeconds(@IntRange(from = 0, to = 59) seconds: Int) {
        _restTimeBetweenExercises.value = _restTimeBetweenExercises.value.copy(seconds = seconds)
    }

    fun setRestTimeBetweenExercisesMinutes(@IntRange(from = 0, to = 59) minutes: Int) {
        _restTimeBetweenExercises.value = _restTimeBetweenExercises.value.copy(minutes = minutes)
    }

    fun changeRoutineName(newRoutineName: String) {
        viewModelScope.launch {
            _name.emit(newRoutineName)
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