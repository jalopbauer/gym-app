package com.indigo.gymapp.manager

import android.content.Context
import com.indigo.gymapp.database.GymDatabase
import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarManagerSingleton
import com.indigo.gymapp.routines.manager.RoutineManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ManagerProvider {

    @Provides
    @Singleton
    fun provideRoutineManager(@ApplicationContext context: Context) : RoutineManager {
        return RoutineManager(GymDatabase.getDatabase(context))
    }

    @Provides
    @Singleton
    fun provideBottomAppBarManager() : BottomAppBarManagerSingleton {
        return BottomAppBarManagerSingleton()
    }
}