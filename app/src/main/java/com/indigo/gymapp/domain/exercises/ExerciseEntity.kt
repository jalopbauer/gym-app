package com.indigo.gymapp.domain.exercises

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EXERCISES")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Long,
    override val name: String,
): Exercise