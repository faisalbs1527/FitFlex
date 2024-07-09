package com.example.fitflex.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.black80

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    HomeScreenSkeleton()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenSkeleton() {
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
        Text(
            text = "Popular Workouts",
            fontSize = 18.sp,
            fontWeight = FontWeight(700),
            fontFamily = Font_LatoBold,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowHomeScreen() {
    FitFlexTheme {
        HomeScreenSkeleton()
    }
}
