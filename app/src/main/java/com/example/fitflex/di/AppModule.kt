package com.example.fitflex.di

import android.content.Context
import com.example.fitflex.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppDB(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase(context)
    }
}