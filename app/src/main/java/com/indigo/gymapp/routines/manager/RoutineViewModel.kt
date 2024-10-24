package com.indigo.gymapp.routines.manager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.RoutineExerciseBuilder
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.exercises.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor(private val routineManager: RoutineManager) : ViewModel(),
    RoutineHandler {

    val name = routineManager.name

    override fun changeRoutineName(newRoutineName: String) {
        routineManager.changeRoutineName(newRoutineName)
    }

    val restTimeBetweenExercises = routineManager.restTimeBetweenExercises

    override fun setRestTimeBetweenExercises(newRest: Rest) {
        routineManager.setRestTimeBetweenExercises(newRest)
    }

    val exercises = routineManager.exercises

    override suspend fun addExercise(routineExercise: RoutineExercise) {
        viewModelScope.launch {
            routineManager.addExercise(routineExercise)
        }
    }

    val routineExerciseBuilder = routineManager.routineExerciseBuilder

    override fun setRoutineExerciseBuilder(routineExerciseBuilder: RoutineExerciseBuilder) {
        routineManager.setRoutineExerciseBuilder(routineExerciseBuilder)
    }

    override fun setRoutineExerciseBuilderRest(newRest: Rest) {
        routineManager.setRoutineExerciseBuilderRest(newRest)
    }

    override fun setRoutineExerciseBuilderExercise(exercise: Exercise) {
        routineManager.setRoutineExerciseBuilderExercise(exercise)
    }

    override fun setRoutineExerciseBuilderAmountOfSets(amountOfSets: Int) {
        routineManager.setRoutineExerciseBuilderAmountOfSets(amountOfSets)
    }

    override fun setInitialRoutineExerciseBuilder() {
        routineManager.setInitialRoutineExerciseBuilder()
    }

    val routines = routineManager.routines

    override suspend fun saveRoutine(): SaveRoutineResult =
        routineManager.saveRoutine()

    override suspend fun setRoutineId(routineId: Long): SetRoutineResult =
        routineManager.setRoutineId(routineId)

    override suspend fun setInitialRoutine() {
        routineManager.setInitialRoutine()
    }
}