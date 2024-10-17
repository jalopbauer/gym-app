package com.indigo.gymapp.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indigo.gymapp.exercises.Exercise
import com.indigo.gymapp.exercises.ExerciseDao
import com.indigo.gymapp.routines.RoutineEntity
import com.indigo.gymapp.routines.RoutinesDao
import java.util.concurrent.Executors

@Database(entities = [Exercise::class, RoutineEntity::class], version = 2)
abstract class GymDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
    abstract fun routinesDao(): RoutinesDao

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