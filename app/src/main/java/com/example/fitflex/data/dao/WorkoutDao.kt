package com.example.fitflex.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.fitflex.domain.model.WorkoutEntity

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(workoutEntity: WorkoutEntity)

    @Query("Select * FROM workouts")
    suspend fun getWorkouts(): List<WorkoutEntity>

    @Query("Select * FROM workouts where id = :id")
    suspend fun getWorkoutById(id: Int): WorkoutEntity

    @Update
    suspend fun updateWorkout(workoutEntity: WorkoutEntity)
}