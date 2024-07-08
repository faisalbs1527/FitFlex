package com.example.fitflex.presentation.onBoarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fitflex.components.CustomButton
import com.example.fitflex.components.PagerScreen
import com.example.fitflex.navigation.Screen
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.utils.OnBoardingPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@Composable
fun OnBoardingScreen(navController: NavController) {
    OnBoardingScreenSkeleton(navController)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreenSkeleton(navController: NavController) {

    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )

    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CustomButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                },
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .weight(1f)
                    .size(width = 350.dp, height = 50.dp),
                pagerState = pagerState
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowOnBoardingScreenSkeleton() {
    FitFlexTheme {
//        OnBoardingScreenSkeleton()
    }
}