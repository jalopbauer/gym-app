package com.indigo.gymapp.navigation

import com.indigo.gymapp.pages.routines.create.RoutineManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonProvider {

    @Provides
    @Singleton
    fun provideRoutineManager() : RoutineManager {
        return RoutineManager()
    }
}