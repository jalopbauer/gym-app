package com.indigo.gymapp.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indigo.gymapp.exercises.entity.ExerciseEntity
import com.indigo.gymapp.exercises.entity.ExerciseEntityDao
import com.indigo.gymapp.routines.RoutineEntity
import com.indigo.gymapp.routines.RoutinesDao
import com.indigo.gymapp.routines.exercises.SetExerciseDao
import com.indigo.gymapp.routines.exercises.SetExerciseEntity
import java.util.concurrent.Executors

@Database(entities = [ExerciseEntity::class, RoutineEntity::class, SetExerciseEntity::class], version = 4)
abstract class GymDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseEntityDao
    abstract fun routinesDao(): RoutinesDao
    abstract fun setExerciseDao(): SetExerciseDao

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