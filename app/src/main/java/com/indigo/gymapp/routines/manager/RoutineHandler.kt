package com.indigo.gymapp.routines.manager

import androidx.annotation.IntRange
import com.indigo.gymapp.domain.routines.exercises.RoutineExercise
import com.indigo.gymapp.domain.routines.exercises.RoutineExerciseBuilder
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.exercises.ExerciseEntity

interface RoutineHandler {

    suspend fun changeRoutineName(newRoutineName: String)

    suspend fun setRestTimeBetweenExercises(newRest: Rest)

    suspend fun addExercise(routineExercise: RoutineExercise)

    fun setRoutineExerciseBuilder(routineExerciseBuilder: RoutineExerciseBuilder)

    fun setRoutineExerciseBuilderRest(newRest: Rest)

    fun setRoutineExerciseBuilderExercise(exercise: ExerciseEntity)

    fun setRoutineExerciseBuilderAmountOfSets(@IntRange(from = 0) amountOfSets: Int)

    fun setInitialRoutineExerciseBuilder()

    suspend fun saveRoutine() : SaveRoutineResult

    suspend fun setRoutineId(routineId: Long) : SetRoutineResult

    suspend fun setInitialRoutine()

    suspend fun deleteRoutine(routineId: Long)

    suspend fun deleteRoutineExercise(routineExerciseId: Long)

}