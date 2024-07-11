package com.example.fitflex.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.black

@Composable
fun CircularProgress(
    progress: Float
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                progress = progress,
                color = Color(0xFFA48AED),
                modifier = Modifier
                    .size(74.dp)
                    .rotate(0f),
                strokeWidth = 12.dp,
                trackColor = Color.White,
                strokeCap = StrokeCap.Round
            )
            Text(
                text = toPercentage(progress),
                fontSize = 14.sp,
                fontFamily = Font_LatoBold,
                fontWeight = FontWeight(600),
                color = black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        CircularProgress(.3f)
    }
}

@SuppressLint("DefaultLocale")
fun toPercentage(progress: Float): String {
    val percentage = String.format("%.0f%%", progress * 100)
    return percentage
}