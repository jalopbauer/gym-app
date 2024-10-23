package com.indigo.gymapp.routines.exercises

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface SetExerciseDao {
    @Insert
    suspend fun insertAll(setExercises: List<SetExerciseEntity>)
}