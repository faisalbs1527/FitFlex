package com.example.fitflex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitflex.presentation.MainScreen
import com.example.fitflex.presentation.explore.ExploreScreen
import com.example.fitflex.presentation.home.HomeScreen
import com.example.fitflex.presentation.onBoarding.OnBoardingScreen
import com.example.fitflex.presentation.workout.WorkoutScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController, selectedItem = 0)
        }
        composable(route = Screen.Welcome.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            MainScreen(navController = navController, selectedItem = 0)
        }
        composable(route = Screen.Workout.route) {
            WorkoutScreen()
        }
        composable(route = Screen.Explore.route) {
            MainScreen(navController = navController, selectedItem = 1)
        }
        composable(route = Screen.Analytics.route) {
            MainScreen(navController = navController, selectedItem = 2)
        }
        composable(route = Screen.Profile.route) {
            MainScreen(navController = navController, selectedItem = 3)
        }
    }
}