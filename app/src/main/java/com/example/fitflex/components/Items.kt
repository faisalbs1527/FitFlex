package com.example.fitflex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.R
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.lightGreen
import com.example.fitflex.ui.theme.transparentColor
import com.example.fitflex.utils.WorkoutCard

@Composable
fun WorkoutCardItem(
    workoutCard: WorkoutCard
) {
    Card(
        modifier = Modifier
            .height(174.dp)
            .width(280.dp)
            .padding(end = 16.dp),
        shape = RoundedCornerShape(23.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = workoutCard.image),
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = workoutCard.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = Font_LatoBold,
                        color = Color.White,
                    )
                    CardItem(
                        itemWidth = 80,
                        iconPainter = painterResource(id = R.drawable.powericon),
                        itemText = workoutCard.energyLoss
                    )
                    CardItem(
                        itemWidth = 72,
                        iconPainter = painterResource(id = R.drawable.timericon),
                        itemText = workoutCard.workoutTime
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .background(
                                color = lightGreen,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "")
                    }
                }

            }
        }
    }
}

@Composable
fun CardItem(
    itemWidth: Int,
    iconPainter: Painter,
    itemText: String
) {
    Card(
        modifier = Modifier
            .height(26.dp)
            .width(itemWidth.dp),
        shape = RoundedCornerShape(9.dp),
        colors = CardDefaults.cardColors(Color.White.copy(alpha = 0.8f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = iconPainter, contentDescription = "",
                modifier = Modifier.size(14.dp)
            )
            Text(
                text = itemText,
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                fontFamily = Font_Lato,
                color = black
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowItems() {
    FitFlexTheme {
        WorkoutCardItem(
           workoutCard = WorkoutCard.First
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowCardItem() {
    FitFlexTheme {
        CardItem(
            itemWidth = 80,
            iconPainter = painterResource(id = R.drawable.powericon),
            itemText = "500 Kcal"
        )
    }
}