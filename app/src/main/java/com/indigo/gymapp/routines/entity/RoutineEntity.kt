package com.indigo.gymapp.routines.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.indigo.gymapp.domain.time.Rest

@Entity(tableName = "ROUTINES")
data class RoutineEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    @Embedded val rest: Rest
)