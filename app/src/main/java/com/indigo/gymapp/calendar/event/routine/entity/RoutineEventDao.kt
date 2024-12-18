package com.indigo.gymapp.calendar.event.routine.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction


@Dao
interface RoutineEventDao {
    @Insert
    suspend fun create(routine: RoutineEventEntity): Long

    @Insert
    suspend fun create(routineEventFrequencies: List<RoutineEventFrequencyEntity>)

    @Transaction
    suspend fun create(
        routineEvent: RoutineEventEntity,
        routineEventFrequencies: List<RoutineEventFrequencyEntity>
    ) {
        val routineEventId = create(routineEvent)

        create(routineEventFrequencies.map { it.copy(routineEventId = routineEventId) })
    }

    @Delete
    suspend fun delete(routine: RoutineEventEntity)

    @Query("SELECT * FROM ROUTINE_EVENT")
    fun getAll(): List<RoutineEventWithRoutineAndFrequency>
}