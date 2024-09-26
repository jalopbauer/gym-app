package com.indigo.gymapp.pages.exercises

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExerciseDao {
    @Insert
    suspend fun create(exercise: Exercise)

    @Update
    suspend fun update(exercise: Exercise)

    @Delete
    suspend fun delete(exercise: Exercise)

    @Query("SELECT * FROM EXERCISES")
    fun getAll(): LiveData<List<Exercise>>

    @Query("SELECT * FROM exercises WHERE name LIKE '%' || :search || '%'")
    fun getExercisesByName(search : String): List<Exercise>}