package com.indigo.gymapp.calendar.event.routine.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.indigo.gymapp.routines.entity.RoutineEntity
import com.indigo.gymapp.time.Duration

@Entity(
    tableName = "ROUTINE_EVENT",
    foreignKeys = [
        ForeignKey(
            entity = RoutineEntity::class,
            parentColumns = ["id"],
            childColumns = ["routineId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RoutineEventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val routineId : Long,
    @Embedded val estimatedDuration: Duration
)


data class RoutineEventWithRoutineAndFrequency(
    @Embedded val routineEventEntity: RoutineEventEntity,
    @Relation(
        parentColumn = "routineId",
        entityColumn = "id"
    )
    val routine: RoutineEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "routineEventId"
    )
    val routineEventFrequencyEntities: List<RoutineEventFrequencyEntity>
)