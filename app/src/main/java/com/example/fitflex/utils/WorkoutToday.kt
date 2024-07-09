package com.example.fitflex.utils

import com.example.fitflex.R

sealed class WorkoutToday(
    val image: Int,
    val title: String,
    val amount: String,
    val status: String,
    val progress: Float
) {

    data object First : WorkoutToday(
        image = R.drawable.pushup,
        title = "Push Up",
        amount = "100 Push up a day",
        status = "Intermediate",
        progress = .45f
    )

    data object Second : WorkoutToday(
        image = R.drawable.situp,
        title = "Sit Up",
        amount = "20 Sit up a day",
        status = "Beginner",
        progress = .75f
    )

    data object Third : WorkoutToday(
        image = R.drawable.kneepushup,
        title = "Knee Push Up",
        amount = "30 Push up a day",
        status = "Beginner",
        progress = .8f
    )
    data object Fourth : WorkoutToday(
        image = R.drawable.jumpingjack,
        title = "Jumping Jack",
        amount = "60 Jumping jack a day",
        status = "Beginner",
        progress = .5f
    )
}