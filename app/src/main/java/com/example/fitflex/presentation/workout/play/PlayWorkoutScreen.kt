package com.example.fitflex.presentation.workout.play

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fitflex.components.DataEntryCard
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.black
import kotlinx.coroutines.delay

@Composable
fun PlayWorkoutScreen(navController: NavController, workoutId: Int) {
    PlayWorkoutScreenSkeleton(navController, workoutId)
}

@Composable
fun PlayWorkoutScreenSkeleton(navController: NavController, workoutId: Int) {

    val viewModel: PlayWorkoutViewModel = hiltViewModel()

    val workoutData by viewModel.workoutData.collectAsState()

    val isTimer = (workoutData?.amount == 0)

    val isRunning by remember {
        mutableStateOf(false)
    }
    var currSeconds by remember {
        mutableIntStateOf(value = 500)
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(isRunning) {
        if (isRunning) {
            while (true) {
                delay(1000)
                currSeconds++
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getWorkout(workoutId)
    }

    workoutData?.let { data ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding()
                    .fillMaxSize()
                    .background(color = black)
                    .verticalScroll(
                        state = rememberScrollState()
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, start = 20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIos, contentDescription = "Back Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                viewModel.updateWorkout()
                                navController.popBackStack()
                            }
                    )
                }

                Card(
                    modifier = Modifier
                        .height(280.dp)
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                    shape = RoundedCornerShape(23.dp)
                ) {
                    Image(
                        painter = painterResource(id = data.image),
                        contentDescription = "Background Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Text(
                    text = data.name,
                    fontSize = 20.sp,
                    fontFamily = Font_LatoBold,
                    fontWeight = FontWeight(800),
                    color = Color.White,
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                )
                Text(
                    text = data.description,
                    fontSize = 15.sp,
                    fontFamily = Font_Lato,
                    fontWeight = FontWeight(400),
                    color = Color.White.copy(.5f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 8.dp)
                )
                DataEntryCard(
                    viewModel = viewModel,
                    isTimer = isTimer,
                    amountData = (if (isTimer) (data.duration / 60).toString() + " Min" else data.amount.toString()),
                    burn = data.burn,
                    curTime = data.remDuration,
                    remaining = data.remAmount.toString()
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ShowPlayWorkoutScreen() {
    FitFlexTheme {
//        PlayWorkoutScreenSkeleton(1)
    }
}