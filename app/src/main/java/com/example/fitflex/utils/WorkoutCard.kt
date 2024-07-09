package com.example.fitflex.utils

import com.example.fitflex.R

sealed class WorkoutCard(
    val image: Int,
    val title: String,
    val energyLoss: String,
    val workoutTime: String
) {
    object First : WorkoutCard(
        image = R.drawable.lowerboady,
        title = "Lower Body Training",
        energyLoss = "500 Kcal",
        workoutTime = "50 Min"
    )

    object Second : WorkoutCard(
        image = R.drawable.upperbody,
        title = "Upper Body Training",
        energyLoss = "650 Kcal",
        workoutTime = "50 Min"
    )

    object Third : WorkoutCard(
        image = R.drawable.hand,
        title = "Hands Training",
        energyLoss = "600 Kcal",
        workoutTime = "40 Min"
    )

    object Fourth : WorkoutCard(
        image = R.drawable.belly,
        title = "Belly Training",
        energyLoss = "700 Kcal",
        workoutTime = "30 Min"
    )
}