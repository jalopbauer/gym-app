package com.indigo.gymapp.calendar.event.routine.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.indigo.gymapp.common.daysOfTheWeek.DayOfTheWeek
import com.indigo.gymapp.common.daysOfTheWeek.getDayFromFullName
import com.indigo.gymapp.common.daysOfTheWeek.getDayFullName

@Entity(
    tableName = "ROUTINE_EVENT_FREQUENCY",
    foreignKeys = [
        ForeignKey(
            entity = RoutineEventEntity::class,
            parentColumns = ["id"],
            childColumns = ["routineEventId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class RoutineEventFrequencyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val routineEventId : Long = 0,
    val dayOfTheWeek: DayOfTheWeek
)

class DayOfWeekConverter {
    @TypeConverter
    fun fromDayOfTheWeek(dayOfTheWeek: DayOfTheWeek): String =
        getDayFullName(dayOfTheWeek)

    @TypeConverter
    fun toDayOfTheWeek(name: String) : DayOfTheWeek =
        getDayFromFullName(name)
}
