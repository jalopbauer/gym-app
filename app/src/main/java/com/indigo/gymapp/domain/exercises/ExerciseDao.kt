package com.indigo.gymapp.domain.exercises

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExerciseDao {
    @Insert
    suspend fun create(exerciseEntity: Exercise)

    @Update
    suspend fun update(exerciseEntity: Exercise)

    @Delete
    suspend fun delete(exerciseEntity: Exercise)

    @Query("SELECT * FROM EXERCISES")
    fun getAll(): LiveData<List<Exercise>>
}