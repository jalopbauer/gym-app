package com.indigo.gymapp.routines.exercises

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.indigo.gymapp.domain.time.Rest

@Entity("SET_EXERCISES")
data class SetExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val routineId : Long,
    val order: Int,
    val exerciseId: Long,
    val amountOfSets: Int,
    @Embedded val rest: Rest
)

data class SetExerciseWithExercise(
    val id: Long,
    val routineId: Long,
    val order: Int,
    val exerciseId: Long,
    val exerciseName: String,
    val amountOfSets: Int,
    @Embedded val rest: Rest
)
