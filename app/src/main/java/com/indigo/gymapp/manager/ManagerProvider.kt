package com.indigo.gymapp.manager

import com.indigo.gymapp.manager.bottomAppBar.BottomAppBarManagerSingleton
import com.indigo.gymapp.routines.manager.RoutineManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ManagerProvider {

    @Provides
    @Singleton
    fun provideRoutineManager() : RoutineManager {
        return RoutineManager()
    }

    @Provides
    @Singleton
    fun provideBottomAppBarManager() : BottomAppBarManagerSingleton {
        return BottomAppBarManagerSingleton()
    }
}