package com.indigo.gymapp.pages.exercises

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EXERCISES")
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
)