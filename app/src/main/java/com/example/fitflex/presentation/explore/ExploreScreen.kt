package com.example.fitflex.presentation.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.R
import com.example.fitflex.components.ChallengeCard
import com.example.fitflex.components.SubTitle
import com.example.fitflex.components.WorkoutBox
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.lightGreen
import com.example.fitflex.ui.theme.transparentColor
import com.example.fitflex.utils.Challenges
import com.example.fitflex.utils.Workouts

@Composable
fun ExploreScreen() {
    ExploreScreenSkeleton()
}

@Composable
fun ExploreScreenSkeleton() {

    val bestList = listOf(
        Workouts.First,
        Workouts.Second,
        Workouts.Third,
        Workouts.Fourth,
        Workouts.Fifth,
        Workouts.Sixth
    )
    val warmupList = listOf(
        Workouts.Fifth,
        Workouts.Sixth,
        Workouts.First,
        Workouts.Third
    )

    val challengeList = listOf(
        Challenges.First,
        Challenges.Second,
        Challenges.Third,
        Challenges.First
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 20.dp)
    ) {

        Card(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .padding(end = 20.dp),
            shape = RoundedCornerShape(23.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.quarantine),
                    contentDescription = "Background Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .drawBehind {
                            drawRect(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Black.copy(alpha = 0.8f),// Adjust alpha for shadow intensity
                                        transparentColor
                                    )
                                )
                            )
                        }
                )
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(.7f),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Best Quarantine Workout",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = Font_LatoBold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 26.dp)
                    )
                    Row(
                        modifier = Modifier.padding(start = 26.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = "See more",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                            fontFamily = Font_LatoBold,
                            color = lightGreen
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowForwardIos, contentDescription = "",
                            tint = lightGreen,
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .size(14.dp)
                        )
                    }
                }
            }
        }
        SubTitle(text = "Best for you")
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier.height(190.dp),
            contentPadding = PaddingValues(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(bestList) {item->
                WorkoutBox(item)
            }
        }
        SubTitle(text = "Challenge")
        LazyRow(
            contentPadding = PaddingValues(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(challengeList){item->
                ChallengeCard(item)
            }
        }
        SubTitle(text = "Fast Warmup")
        LazyRow(
            contentPadding = PaddingValues(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(warmupList){item->
                WorkoutBox(item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowExploreScreen() {
    FitFlexTheme {
        ExploreScreenSkeleton()
    }
}
