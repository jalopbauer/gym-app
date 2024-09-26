package com.indigo.gymapp.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indigo.gymapp.domain.exercises.Exercise
import com.indigo.gymapp.domain.exercises.ExerciseDao
import java.util.concurrent.Executors

@Database(entities = [Exercise::class], version = 1)
abstract class GymDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao

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
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}