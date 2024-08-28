package com.indigo.gymapp.routines.create.exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExercisesViewModel @Inject constructor() : ViewModel() {

    private var _exercises = MutableStateFlow(listOf<Exercise>())
    val exercises = _exercises.asStateFlow()

    fun addExercise(exercise: Exercise) {
        val newList = _exercises.value + exercise
        viewModelScope.launch {
            _exercises.emit(newList)
        }
    }
}