package com.example.fitflex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.R
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.black
import com.example.fitflex.utils.Workouts

@Composable
fun WorkoutBox(
    workouts: Workouts = Workouts.Second
) {
    Card(
        modifier = Modifier
            .height(86.dp)
            .width(210.dp),
        shape = RoundedCornerShape(9.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .size(72.dp)
            ) {
                Image(
                    painter = painterResource(id = workouts.image), contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 2.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = workouts.title,
                    color = black,
                    fontWeight = FontWeight(600),
                    fontFamily = Font_Lato,
                    fontSize = 14.sp
                )
                TextBox(text = workouts.workoutTime)
                TextBox(text = workouts.status)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ShowItems() {
    FitFlexTheme {
        WorkoutBox()
    }
}