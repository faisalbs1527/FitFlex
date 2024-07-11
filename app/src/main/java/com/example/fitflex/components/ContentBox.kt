package com.example.fitflex.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.black

@Composable
fun ContentBox(
    height: Dp,
    width: Dp,
    color: Color,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = color),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .width(width)
                .height(height)
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            header()
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        ContentBox(
            height = 132.dp,
            width = 112.dp,
            color = Color(0xFFFFE8C6),
            header = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Training time",
                        fontSize = 13.sp,
                        fontFamily = Font_Lato,
                        fontWeight = FontWeight(500),
                        color = black
                    )
                }
            },
            content = {
                CircularProgress(progress = .7f)
            }
        )
    }
}

@Composable
fun Header(
    icon: Int,
    color: Color,
    text: String,
    textColor: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        IconBox(
            iconPainter = painterResource(id = icon),
            containerColor = color,
            containerSize = 28.dp
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = Font_Lato,
            fontWeight = FontWeight(700),
            color = textColor
        )
    }
}