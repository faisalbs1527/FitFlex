package com.example.fitflex.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen(route = "OnBoardingScreen")
    object Home : Screen(route = "HomeScreen")
}