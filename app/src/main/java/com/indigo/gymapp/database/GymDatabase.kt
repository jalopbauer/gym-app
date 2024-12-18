package com.indigo.gymapp.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.indigo.gymapp.exercises.entity.ExerciseEntity
import com.indigo.gymapp.exercises.entity.ExerciseEntityDao
import com.indigo.gymapp.routines.entity.RoutineEntity
import com.indigo.gymapp.routines.entity.RoutinesDao
import com.indigo.gymapp.routines.exercises.entity.SetExerciseDao
import com.indigo.gymapp.routines.exercises.entity.SetExerciseEntity
import java.util.concurrent.Executors
import com.indigo.gymapp.calendar.event.routine.entity.DayOfWeekConverter
import com.indigo.gymapp.calendar.event.routine.entity.RoutineEventDao
import com.indigo.gymapp.calendar.event.routine.entity.RoutineEventFrequencyEntity
import com.indigo.gymapp.calendar.event.routine.entity.RoutineEventEntity

@Database(
    entities = [
        ExerciseEntity::class, RoutineEntity::class, SetExerciseEntity::class,
        RoutineEventEntity::class, RoutineEventFrequencyEntity::class
   ], version = 8)
@TypeConverters(DayOfWeekConverter::class)
abstract class GymDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseEntityDao
    abstract fun routinesDao(): RoutinesDao
    abstract fun setExerciseDao(): SetExerciseDao

    abstract fun routinesEventDao(): RoutineEventDao

    companion object {
        @Volatile
        private var INSTANCE: GymDatabase? = null

        fun getDatabase(context: Context): GymDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GymDatabase::class.java,
                    "gym_database"
                ).setQueryCallback(
                    { sqlQuery, bindArgs ->
                        Log.d("RoomQuery", "Query: $sqlQuery SQL Args: $bindArgs")
                    },
                    Executors.newSingleThreadExecutor() // Use an executor for handling logs
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}