package com.example.fitflex.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workouts")
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val image: Int,
    val level: String,
    val duration: String,
    val amount: Int
)
