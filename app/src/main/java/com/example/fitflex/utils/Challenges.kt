package com.example.fitflex.utils

import androidx.compose.ui.graphics.Color
import com.example.fitflex.R
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.lightGreen

sealed class Challenges(
    val containerColor: Color,
    val text: String,
    val textColor: Color,
    val icon: Int,
    val iconColor: Color
) {

    data object First : Challenges(
        containerColor = lightGreen,
        text = "Plank Challenge",
        textColor = black,
        icon = R.drawable.powericon,
        iconColor = Color.White.copy(.6f)
    )
    data object Second : Challenges(
        containerColor = black,
        text = "Sprint Challenge",
        textColor = Color.White,
        icon = R.drawable.sprint,
        iconColor = Color.White.copy(.6f)
    )
    data object Third : Challenges(
        containerColor = Color.White,
        text = "Squat Challenge",
        textColor = black,
        icon = R.drawable.squat,
        iconColor = lightGreen.copy(.6f)
    )
}