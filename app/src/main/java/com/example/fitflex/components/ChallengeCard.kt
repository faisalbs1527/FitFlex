package com.example.fitflex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.R
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.lightGreen

@Composable
fun ChallengeCard(
    containerColor: Color = lightGreen,
    text: String = "Plank Challenge",
    textColor: Color = black,
    icon: Painter = painterResource(id = R.drawable.powericon),
    iconColor: Color = Color.White.copy(.6f)
) {
    Box(
        modifier = Modifier
            .size(110.dp)
            .background(color = containerColor, shape = RoundedCornerShape(9.dp))
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = icon,
                contentDescription = "",
                modifier = Modifier.size(72.dp),
                tint = iconColor
            )
        }
        Row(
            modifier = Modifier
                .padding(start = 8.dp, bottom = 12.dp)
                .fillMaxHeight()
                .fillMaxWidth(.7f),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        )
        {
            Text(
                text = text,
                color = textColor,
                fontWeight = FontWeight(600),
                fontFamily = Font_Lato,
                fontSize = 14.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        ChallengeCard()
    }
}