package com.example.fitflex.utils

import com.example.fitflex.R

sealed class RoundsCard(
    val image: Int,
    val title: String,
    val time: String
) {
    data object First: RoundsCard(
        image = R.drawable.jumpingjack,
        title = "Jumping Jacks",
        time = "00:30"
    )
    data object Second: RoundsCard(
        image = R.drawable.squats,
        title = "Squats",
        time = "00:45"
    )
    data object Third: RoundsCard(
        image = R.drawable.backyardlaunge,
        title = "Backward Lunge",
        time = "00:40"
    )
    data object Fourth: RoundsCard(
        image = R.drawable.hillclimbing,
        title = "Mountain Climbing",
        time = "00:30"
    )
    data object Fifth: RoundsCard(
        image = R.drawable.plank,
        title = "Plank",
        time = "00:50"
    )
}