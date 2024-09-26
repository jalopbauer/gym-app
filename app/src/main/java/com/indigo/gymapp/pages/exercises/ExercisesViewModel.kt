package com.indigo.gymapp.pages.exercises

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.database.GymDatabase
import com.indigo.gymapp.domain.exercises.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    @ApplicationContext val context: Context,
) : ViewModel() {

    private val gymDatabase = GymDatabase.getDatabase(context)

    val exercises = gymDatabase.exerciseDao().getAll().asFlow()

    fun createExercise(exerciseName: String) {
        val exercise = Exercise(name = exerciseName)
        viewModelScope.launch {
            gymDatabase.exerciseDao().create(exercise)
        }
    }


    private var _search = MutableStateFlow("")
    val exerciseSearchText = _search.asStateFlow()

    private var _searchExercises = MutableStateFlow(listOf<Exercise>())
    val searchExercises = _searchExercises.asStateFlow()

    fun searchExercise(exerciseName: String) {
        _search.value = exerciseName
        viewModelScope.launch {
            if (exerciseName == "") {
                _searchExercises.emit(emptyList())
            } else {
                withContext(Dispatchers.Default) {
                    _searchExercises.emit(gymDatabase.exerciseDao().getExercisesByName(exerciseName))
                }
            }
        }
    }
}