package com.indigo.gymapp.exercises.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.database.GymDatabase
import com.indigo.gymapp.exercises.Exercise
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
    private val exerciseDao = gymDatabase.exerciseDao()
    private val setExerciseDao = gymDatabase.setExerciseDao()

    val exercises = exerciseDao.getAll().asFlow()

    suspend fun createExercise(exerciseName: String): Result<Unit> {
        val exercise = Exercise(name = exerciseName)
        return withContext(Dispatchers.Default) {
            return@withContext runCatching {
                exerciseDao.create(exercise)
            }
        }
    }


    private var _search = MutableStateFlow("")
    val exerciseSearchText = _search.asStateFlow()

    private var _searchExercises = MutableStateFlow(listOf<Exercise>())
    val searchExercises = _searchExercises.asStateFlow()

    fun searchExercise(exerciseName: String) {
        _search.value = exerciseName
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _searchExercises.emit(exerciseDao.getExercisesByName(exerciseName))
            }
        }
    }

    fun deleteExercise(id : Long) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                setExerciseDao.deleteByExerciseId(id)
                exerciseDao.deleteById(id)
            }
        }
    }
}