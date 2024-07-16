package com.example.fitflex.navigation

sealed class Screen(val route: String) {
    object MainScreen : Screen(route = "MainScreen")
    object Welcome : Screen(route = "OnBoardingScreen")
    object Home : Screen(route = "HomeScreen")
    object Workout : Screen(route = "WorkoutScreen")
    object Explore : Screen(route = "ExploreScreen")
    object Analytics : Screen(route = "AnalyticsScreen")
    object Profile : Screen(route = "ProfileScreen")
    object PlayWorkout : Screen(route = "PlayWorkoutScreen/{workoutId}") {
        fun createRoute(id: Int) = route.replaceFirst("{workoutId}", "$id")
    }
}