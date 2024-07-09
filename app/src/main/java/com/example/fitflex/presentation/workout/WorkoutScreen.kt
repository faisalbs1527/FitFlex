package com.example.fitflex.presentation.workout

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
import com.example.fitflex.components.DetailsBox
import com.example.fitflex.components.RoundsItem
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.Font_LatoBold
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
                    color = Color.White,
                    modifier = Modifier.padding(end = 24.dp)
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 16.dp, top = 20.dp),
                shape = RoundedCornerShape(23.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.upperbody),
                    contentDescription = "Background Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 64.dp, end = 64.dp, top = 220.dp)
                    .background(
                        color = Color.Black.copy(alpha = .4f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                DetailsBox(image = R.drawable.timericon, title = "Time", text = "20 min")
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(color = Color.White.copy(alpha = .7f))
                )
                DetailsBox(image = R.drawable.powericon, title = "Burn", text = "95 kcal")
            }
        }
        Text(
            text = "Lower Body Training",
            fontSize = 24.sp,
            fontWeight = FontWeight(800),
            fontFamily = Font_LatoBold,
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp, top = 8.dp)
        )
        Text(
            text = "The lower abdomen and hips are the most difficult areas of the body to reduce when we are on a diet. Even so, in this area, especially the legs as a whole, you can reduce weight even if you don't use tools.",
            fontSize = 15.sp,
            fontWeight = FontWeight(400),
            fontFamily = Font_Lato,
            color = Color.White.copy(alpha = .5f),
            modifier = Modifier.padding(start = 20.dp, end = 16.dp, top = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 16.dp, top = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Rounds",
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                fontFamily = Font_LatoBold,
                color = Color.White
            )
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "1",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = Font_Lato,
                    color = Color.White
                )
                Text(
                    text = "/8",
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = Font_Lato,
                    color = Color.White
                )
            }
        }
        LazyColumn(
            modifier = Modifier.padding(start = 20.dp, end = 16.dp, top = 8.dp)
        ) {
            items(8) {
                RoundsItem()
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