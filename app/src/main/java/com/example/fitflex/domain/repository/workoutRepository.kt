package com.example.fitflex.domain.repository

import com.example.fitflex.domain.model.WorkoutEntity

interface WorkoutRepository {

    suspend fun insertDummyData(workoutEntity: WorkoutEntity)
    suspend fun getWorkouts(): List<WorkoutEntity>
    suspend fun getWorkoutById(id: Int): WorkoutEntity
    suspend fun updateWorkout(workoutEntity: WorkoutEntity)
}