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

sealed class Workouts(
    val image: Int,
    val title: String,
    val status: String,
    val workoutTime: String
) {
    data object First : Workouts(
        image = R.drawable.bellyfat,
        title = "Belly fat burner",
        status = "Beginner",
        workoutTime = "10 Min"
    )

    data object Second : Workouts(
        image = R.drawable.plank,
        title = "Plank",
        status = "Expert",
        workoutTime = "5 Min"
    )

    data object Third : Workouts(
        image = R.drawable.losefat,
        title = "Lose Fat",
        status = "Beginner",
        workoutTime = "50 Min"
    )

    data object Fourth : Workouts(
        image = R.drawable.buildwhid,
        title = "Build whider hand",
        status = "Intermediate",
        workoutTime = "30 Min"
    )

    data object Fifth : Workouts(
        image = R.drawable.legexercise,
        title = "Leg exercises",
        status = "Beginner",
        workoutTime = "10 Min"
    )

    data object Sixth : Workouts(
        image = R.drawable.backward,
        title = "Backward lunge",
        status = "Beginner",
        workoutTime = "5 Min"
    )
}