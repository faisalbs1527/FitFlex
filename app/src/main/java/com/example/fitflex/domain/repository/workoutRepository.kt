package com.example.fitflex.domain.repository

import com.example.fitflex.domain.model.WorkoutEntity

interface WorkoutRepository {
    suspend fun getWorkouts(): List<WorkoutEntity>
}