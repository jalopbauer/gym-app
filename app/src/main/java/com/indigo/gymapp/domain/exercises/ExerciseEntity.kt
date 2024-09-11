package com.indigo.gymapp.domain.exercises

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EXERCISES")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Long = 0,
    override val name: String,
): Exercise