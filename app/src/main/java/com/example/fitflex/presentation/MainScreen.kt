package com.example.fitflex.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.fitflex.components.NavBar
import com.example.fitflex.components.NavBarItem
import com.example.fitflex.navigation.Screen
import com.example.fitflex.presentation.analytics.AnalyticsScreen
import com.example.fitflex.presentation.explore.ExploreScreen
import com.example.fitflex.presentation.home.HomeScreen
import com.example.fitflex.presentation.profile.ProfileScreen
import com.example.fitflex.utils.NavItems

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    navController: NavController,
    selectedItem: Int
) {

    val items = listOf(
        NavItems.Home,
        NavItems.Explore,
        NavItems.Statistic,
        NavItems.Profile,
    )
    val selectedIndex = remember {
        mutableStateOf(selectedItem)
    }
    Scaffold(
        bottomBar = {
            NavBar {
                items.forEach {
                    NavBarItem(
                        onClick = {
                            selectedIndex.value = it.no
                            navController.navigate(it.route)
                        },
                        navItems = it,
                        selected = selectedIndex.value == it.no
                    )
                }
            }
        }
    ) { innerPadding ->
        when (navController.currentDestination?.route) {
            Screen.Home.route -> HomeScreen(
                navController = navController,
                innerPadding = innerPadding
            )

            Screen.Explore.route -> ExploreScreen(innerPadding)
            Screen.Analytics.route -> AnalyticsScreen()
            Screen.Profile.route -> ProfileScreen()
            else -> HomeScreen(
                navController = navController,
                innerPadding = innerPadding
            )
        }
    }
}