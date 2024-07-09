package com.example.fitflex.presentation.workout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.black

@Composable
fun WorkoutScreen(modifier: Modifier = Modifier) {
    WorkoutScreenSkeleton()
}

@Composable
fun WorkoutScreenSkeleton() {
    Column(
        modifier = Modifier
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
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Workout",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color.White
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        WorkoutScreenSkeleton()
    }
}