package com.indigo.gymapp.pages.exercises

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.service.api.exercises.Exercise
import com.indigo.gymapp.service.api.exercises.ExercisesServiceApi
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApiExercisesViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val exercisesServiceApi: ExercisesServiceApi,
): ViewModel() {
    private val _loadingExercises = MutableStateFlow(false)
    val loadingExercises = _loadingExercises.asStateFlow()

    private val _exercises = MutableStateFlow(listOf<Exercise>())
    val exercises = _exercises.asStateFlow()

    private val _showRetry = MutableStateFlow(false)
    val showRetry = _showRetry.asStateFlow()

    init {
        loadRanking()
    }

    fun retryLoadingRanking() {
        loadRanking()
    }

    private fun loadRanking() {
        _loadingExercises.value = true
        exercisesServiceApi.getExercises(
            context = context,
            onSuccess = {
                viewModelScope.launch {
                    _exercises.value = it
                }
                _showRetry.value = false
            },
            onFail = {
                _showRetry.value = true
            },
            loadingFinished = {
                _loadingExercises.value = false
            }
        )
    }
}