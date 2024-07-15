package com.example.fitflex.presentation.workout.play

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.R
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.gray
import com.example.fitflex.ui.theme.lightGreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PlayWorkoutScreen() {
    PlayWorkoutScreenSkeleton()
}

@Composable
fun PlayWorkoutScreenSkeleton() {

    var isRunning by remember {
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

    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize()
            .background(color = black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 20.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIos, contentDescription = "Back Icon",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

        Card(
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 30.dp),
            shape = RoundedCornerShape(23.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.plank),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Text(
            text = "Plank",
            fontSize = 20.sp,
            fontFamily = Font_LatoBold,
            fontWeight = FontWeight(800),
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
        Text(
            text = "Plank is a core exercise where you hold a straight position on forearms and toes to strengthen your abs, back, and shoulders",
            fontSize = 15.sp,
            fontFamily = Font_Lato,
            fontWeight = FontWeight(400),
            color = Color.White.copy(.5f),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 8.dp)
        )

        Column(
            modifier = Modifier
                .padding(top = 40.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Remaining",
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight(800),
                color = Color.White.copy(.6f),
                modifier = Modifier.padding(top = 20.dp)
            )
            Text(
                text = formatTime(currSeconds),
                fontSize = 40.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight(800),
                color = Color.White,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ContentBox(title = "Time", text = "20 Min")
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .background(
                            color = lightGreen,
                            shape = CircleShape
                        )
                        .clickable {
                            scope.launch {
                                isRunning = !isRunning
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isRunning) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                        contentDescription = "",
                        tint = black
                    )
                }
                ContentBox(title = "Burn", text = "60 Cal")
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun ShowPlayWorkoutScreen() {
    FitFlexTheme {
        PlayWorkoutScreenSkeleton()
    }
}

@SuppressLint("DefaultLocale")
fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return String.format("%02d:%02d", minutes, remainingSeconds)
}

@Composable
fun ContentBox(
    title: String,
    text: String
) {
    Column(
        modifier = Modifier
            .background(
                color = gray.copy(.2f),
                shape = RoundedCornerShape(46.dp)
            )
            .padding(vertical = 20.dp, horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontFamily = Font_LatoBold,
            fontWeight = FontWeight(800),
            color = Color.White.copy(0.7f)
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = Font_LatoBold,
            fontWeight = FontWeight(800),
            color = Color.White
        )
    }
}