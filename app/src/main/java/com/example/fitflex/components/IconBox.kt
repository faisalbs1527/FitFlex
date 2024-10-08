package com.example.fitflex.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.R
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.lightGreen


@Composable
fun DetailsBox(
    image: Int,
    title: String,
    text: String
) {
    Row(
    ) {
        IconBox(
            iconPainter = painterResource(id = image),
            containerColor = lightGreen,
            containerSize = 30.dp
        )
        Column {
            Text(
                text = title,
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color.White,
                modifier = Modifier.padding(start = 4.dp)
            )
            Text(
                text = text,
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = lightGreen,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}


@Composable
fun IconBox(
    iconPainter: Painter,
    containerColor: Color,
    containerSize:Dp
) {
    Card(
        modifier = Modifier.size(containerSize),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                iconPainter, contentDescription = "",
                tint = black,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 16.dp, bottom = 8.dp)
            .height(56.dp)
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(containerColor = lightGreen),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                fontSize = 17.sp,
                color = black,
                fontWeight = FontWeight(500)
            )
        }
    }
}

@Preview
@Composable
private fun ShowDetailsBox() {
    FitFlexTheme {
        DetailsBox(
            image = R.drawable.timericon,
            title = "Time",
            text = "20 min"
        )
    }
}

@Preview
@Composable
private fun ViewIconBox() {
    FitFlexTheme {
        CustomButton(onClick = { /*TODO*/ }, text = "Lets Workout")

    }
}
