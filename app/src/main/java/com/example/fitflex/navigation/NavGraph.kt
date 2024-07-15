package com.example.fitflex.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitflex.presentation.MainScreen
import com.example.fitflex.presentation.onBoarding.OnBoardingScreen
import com.example.fitflex.presentation.workout.category.WorkoutScreen

@OptIn(ExperimentalAnimationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController, selectedItem = 0)
        }
        composable(route = Screen.Welcome.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(
            route = Screen.Home.route,
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) {
            MainScreen(navController = navController, selectedItem = 0)
        }
        composable(
            route = Screen.Workout.route,
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) {
            WorkoutScreen()
        }
        composable(route = Screen.Explore.route,
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }) {
            MainScreen(navController = navController, selectedItem = 1)
        }
        composable(
            route = Screen.Analytics.route,
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) {
            MainScreen(navController = navController, selectedItem = 2)
        }
        composable(
            route = Screen.Profile.route,
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) {
            MainScreen(navController = navController, selectedItem = 3)
        }
    }
}