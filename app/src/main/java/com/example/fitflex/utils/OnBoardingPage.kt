package com.example.fitflex.utils

import com.example.fitflex.R

sealed class OnBoardingPage(
    val image: Int,
    val tittle: String,
    val description: String
) {
    object First: OnBoardingPage(
        image = R.drawable.onboardingimage1,
        tittle = "Achieve Your Fitness Goals \nwith Ease",
        description = "Health is earned through daily choices not quick fixes"
    )

    object Second: OnBoardingPage(
        image = R.drawable.onboardingimage2,
        tittle = "Get Fit, Stay Healthy \nAnd Live Better",
        description = "A healthy lifestyle is a journey, not a destination"
    )

    object Third: OnBoardingPage(
        image = R.drawable.onboardimage,
        tittle = "Wherever You Are \nHealth Is Number One",
        description = "There is no instant way to a healthy life"
    )
}