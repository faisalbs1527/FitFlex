package com.example.fitflex.data

import com.example.fitflex.domain.model.WorkoutEntity
import com.example.fitflex.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl: WorkoutRepository {
    override suspend fun getWorkouts(): List<WorkoutEntity> {
        TODO("Not yet implemented")
    }
}