package com.example.fitflex.utils

import com.example.fitflex.R
import com.example.fitflex.domain.model.WorkoutEntity

object DummyData {

    val First = WorkoutEntity(
        id = 1,
        name = "Push Up",
        description = "",
        image = R.drawable.pushup,
        level = "Intermediate",
        duration = 0,
        remDuration = 0,
        amount = 60,
        remAmount = 50
    )

    val Second = WorkoutEntity(
        id = 2,
        name = "Sit Up",
        description = "",
        image = R.drawable.situp,
        level = "Beginner",
        duration = 0,
        remDuration = 0,
        amount = 100,
        remAmount = 90
    )

    val Third = WorkoutEntity(
        id = 3,
        name = "Knee Push Up",
        description = "",
        image = R.drawable.kneepushup,
        level = "Beginner",
        duration = 0,
        remDuration = 0,
        amount = 50,
        remAmount = 30
    )

    val Fourth = WorkoutEntity(
        id = 4,
        name = "Jumping Jack",
        description = "",
        image = R.drawable.jumpingjack,
        level = "Beginner",
        duration = 0,
        remDuration = 0,
        amount = 50,
        remAmount = 40
    )

}