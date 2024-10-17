package com.indigo.gymapp.routines

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RoutinesDao {
    @Insert
    suspend fun create(routine: RoutineEntity) : Long

    @Update
    suspend fun update(routine: RoutineEntity)

    @Delete
    suspend fun delete(routine: RoutineEntity)

    @Query("SELECT * FROM ROUTINES")
    fun getAll(): LiveData<List<RoutineEntity>>
}