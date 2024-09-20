package com.example.fitflex.components

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitflex.ui.theme.FitFlexTheme

@Composable
fun BarChart() {
    val point = listOf(
        Point(10, 200),
        Point(90, 100),
        Point(170, 40),
        Point(250, 200),
        Point(330, 120),
        Point(410, 100),
        Point(490, 200),
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Canvas(
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .background(Color.Transparent)
                .padding(8.dp)
        ) {
            drawLine(
                start = Offset(10f, 600f),
                end = Offset(10f, 0f),
                color = Color.Black,
                strokeWidth = 2f
            )
            drawLine(
                start = Offset(10f, 600f),
                end = Offset(600f, 600f),
                color = Color.Black,
                strokeWidth = 1f
            )

            for (p in point) {
                drawRect(
                    color = Color.DarkGray,
                    topLeft = Offset(p.x + 30f, 600 - (600f - p.y)),
                    size = Size(40f, (600f - p.y))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        BarChart()
    }
}