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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
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
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.lightGreen
import com.example.fitflex.utils.RoundsCard

@Composable
fun RoundsItem(
    roundsCard: RoundsCard
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                color = Color(0xFF384046),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 2.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Card(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .size(58.dp)
            ) {
                Image(
                    painter = painterResource(id = roundsCard.image), contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .height(58.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = roundsCard.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = Font_Lato,
                    color = Color.White
                )
                Text(
                    text = roundsCard.time,
                    fontSize = 13.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = Font_Lato,
                    color = Color.White.copy(alpha = .5f)
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .size(38.dp)
                .background(
                    color = black,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.PlayArrow, contentDescription = "",
                tint = lightGreen
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        RoundsItem(RoundsCard.Third)
    }
}