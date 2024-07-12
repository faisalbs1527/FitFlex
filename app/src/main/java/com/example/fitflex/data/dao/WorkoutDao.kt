package com.example.fitflex.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.fitflex.domain.model.WorkoutEntity

@Dao
interface WorkoutDao {

    @Query("Select * FROM workouts")
    suspend fun getWorkouts(): List<WorkoutEntity>
}