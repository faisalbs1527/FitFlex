package com.example.fitflex.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItems(
    val no: Int,
    val icon: ImageVector,
    val name: String,
    val route: String
) {
    object Home:NavItems(
        no=0,
        icon = Icons.Filled.Home,
        name = "Home",
        route = "HomeScreen"
    )
    object Explore:NavItems(
        no=1,
        icon = Icons.Filled.RocketLaunch,
        name = "Explore",
        route = "ExploreScreen"
    )
    object Statistic:NavItems(
        no=2,
        icon = Icons.Filled.Analytics,
        name = "Analytics",
        route = "AnalyticsScreen"
    )
    object Profile:NavItems(
        no=3,
        icon = Icons.Filled.ManageAccounts,
        name = "Profile",
        route = "ProfileScreen"
    )
}