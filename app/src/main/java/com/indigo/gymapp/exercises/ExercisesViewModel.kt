package com.indigo.gymapp.exercises

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.domain.database.GymDatabase
import com.indigo.gymapp.domain.exercises.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
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
}