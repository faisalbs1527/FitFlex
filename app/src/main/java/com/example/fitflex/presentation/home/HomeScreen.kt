package com.example.fitflex.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitflex.components.PlanCard
import com.example.fitflex.components.SubTitle
import com.example.fitflex.components.WorkoutCardItem
import com.example.fitflex.navigation.Screen
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.black80
import com.example.fitflex.utils.WorkoutCard
import com.example.fitflex.utils.WorkoutToday

@Composable
fun HomeScreen(navController: NavController) {
    HomeScreenSkeleton(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenSkeleton(navController: NavController) {

    val cardList = listOf(
        WorkoutCard.First,
        WorkoutCard.Second,
        WorkoutCard.Third,
        WorkoutCard.Fourth
    )

    val planList = listOf(
        WorkoutToday.First,
        WorkoutToday.Second,
        WorkoutToday.Third,
        WorkoutToday.Fourth
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp)
    ) {
        Text(
            text = "Good Morning \uD83D\uDD25",
            fontSize = 14.sp,
            fontWeight = FontWeight(600),
            fontFamily = Font_Lato,
            modifier = Modifier.padding(top = 30.dp)
        )
        Text(
            text = "Faisal Ahammed",
            fontSize = 24.sp,
            fontWeight = FontWeight(800),
            fontFamily = Font_LatoBold,
            modifier = Modifier.padding(top = 4.dp)
        )
        SearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            modifier = Modifier
                .padding(end = 20.dp, top = 16.dp)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            placeholder = {
                Text(
                    text = "Search",
                    fontSize = 14.sp,
                    color = black80,
                    fontFamily = Font_Lato,
                    fontWeight = FontWeight(400)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = black80
                )
            }) {

        }
        SubTitle(text = "Popular Workouts")
        LazyRow(modifier = Modifier.padding(top = 16.dp)) {
            items(cardList) { item ->
                WorkoutCardItem(workoutCard = item,
                    onClick = {
                        navController.navigate(Screen.Workout.route)
                    })
            }
        }
        SubTitle(text = "Today's Plan")
        LazyColumn {
            items(planList) { item ->
                PlanCard(workoutToday = item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowHomeScreen() {
    FitFlexTheme {
//        HomeScreenSkeleton()
    }
}
