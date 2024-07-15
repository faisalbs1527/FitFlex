package com.example.fitflex.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitflex.domain.model.WorkoutEntity

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(workoutEntity: WorkoutEntity)

    @Query("Select * FROM workouts")
    suspend fun getWorkouts(): List<WorkoutEntity>
}