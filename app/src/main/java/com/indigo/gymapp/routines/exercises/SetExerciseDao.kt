package com.indigo.gymapp.routines.exercises

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SetExerciseDao {
    @Insert
    suspend fun insertAll(setExercises: List<SetExerciseEntity>)

    @Query("""
        SELECT se.*, e.id as exerciseId, e.name as exerciseName 
        FROM SET_EXERCISES se 
        JOIN EXERCISES e ON se.exerciseId = e.id 
        WHERE se.routineId = :routineId 
        ORDER BY se.`order` ASC
    """)
    fun getAllByRoutineIdWithExercise(routineId: Long): List<SetExerciseWithExercise>

}