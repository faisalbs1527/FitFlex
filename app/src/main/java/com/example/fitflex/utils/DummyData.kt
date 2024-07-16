package com.example.fitflex.utils

import com.example.fitflex.R
import com.example.fitflex.domain.model.WorkoutEntity

object DummyData {

    val First = WorkoutEntity(
        id = 1,
        name = "Push Up",
        description = "A push-up is a bodyweight exercise where you lower and raise your body by bending and straightening your arms while keeping your body in a plank position.",
        image = R.drawable.pushup,
        level = "Intermediate",
        burn = "60 Cal",
        duration = 0,
        remDuration = 0,
        amount = 60,
        remAmount = 50
    )

    val Second = WorkoutEntity(
        id = 2,
        name = "Sit Up",
        description = "A sit-up involves lying on your back and lifting your torso towards your knees.",
        image = R.drawable.situp,
        level = "Beginner",
        burn = "50 Cal",
        duration = 0,
        remDuration = 0,
        amount = 100,
        remAmount = 90
    )

    val Third = WorkoutEntity(
        id = 3,
        name = "Knee Push Up",
        description = "A knee push-up is a modified push-up performed with your knees on the ground, reducing the amount of body weight you lift.",
        image = R.drawable.kneepushup,
        level = "Beginner",
        burn = "70 Cal",
        duration = 0,
        remDuration = 0,
        amount = 50,
        remAmount = 30
    )

    val Fourth = WorkoutEntity(
        id = 4,
        name = "Jumping Jack",
        description = "A jumping jack is a full-body exercise where you jump, spreading your legs and raising your arms overhead, then return to the starting position.",
        image = R.drawable.jumpingjack,
        level = "Beginner",
        burn = "80 Cal",
        duration = 180,
        remDuration = 170,
        amount = 0,
        remAmount = 0
    )
    val Fifth = WorkoutEntity(
        id = 5,
        name = "Plank",
        description = "Plank is a core exercise where you hold a straight position on forearms and toes to strengthen your abs, back, and shoulders",
        image = R.drawable.plank,
        level = "Intermediate",
        burn = "70 Cal",
        duration = 300,
        remDuration = 300,
        amount = 0,
        remAmount = 0
    )

}