package com.example.fitflex.di

import com.example.fitflex.data.WorkoutRepositoryImpl
import com.example.fitflex.domain.repository.WorkoutRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(impl: WorkoutRepositoryImpl): WorkoutRepository
}