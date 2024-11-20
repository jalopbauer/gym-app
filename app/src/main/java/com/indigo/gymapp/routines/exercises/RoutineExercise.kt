package com.indigo.gymapp.routines.exercises

import com.indigo.gymapp.domain.time.Duration
import com.indigo.gymapp.domain.time.Rest
import com.indigo.gymapp.exercises.entity.ExerciseEntity

sealed interface RoutineExercise {
    val id : Long
    val exercise : ExerciseEntity
    fun setId(id: Long) : RoutineExercise
}

data class SetExercise(override val id: Long = 0, override val exercise: ExerciseEntity, val amountOfSets: Int, val rest: Rest) : RoutineExercise {
    override fun setId(id: Long): RoutineExercise = this.copy(id = id)
}

data class TimedExercise(override val id: Long = 0, override val exercise: ExerciseEntity, val duration: Duration) : RoutineExercise {
    override fun setId(id: Long): RoutineExercise = this.copy(id = id)
}