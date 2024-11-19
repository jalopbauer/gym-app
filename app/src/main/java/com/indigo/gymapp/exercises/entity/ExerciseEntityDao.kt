package com.indigo.gymapp.exercises.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExerciseEntityDao {
    @Insert
    suspend fun create(exercise: ExerciseEntity)

    @Update
    suspend fun update(exercise: ExerciseEntity)

    @Delete
    suspend fun delete(exercise: ExerciseEntity)

    @Query("SELECT * FROM EXERCISES")
    fun getAll(): LiveData<List<ExerciseEntity>>

    @Query("SELECT * FROM exercises WHERE name LIKE '%' || :search || '%'")
    fun getExercisesByName(search : String): List<ExerciseEntity>

    @Query("DELETE FROM EXERCISES WHERE id = :id")
    suspend fun deleteById(id: Long)
}