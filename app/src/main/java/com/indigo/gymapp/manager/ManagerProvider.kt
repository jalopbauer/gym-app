package com.indigo.gymapp.manager

import com.indigo.gymapp.pages.routines.routineHandler.RoutineManager
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
}