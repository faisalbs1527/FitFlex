package com.example.fitflex.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.black

@Composable
fun LinearProgress(
    stepsTotal: Int,
    stepsDone: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$stepsDone/$stepsTotal",
            fontSize = 13.sp,
            fontFamily = Font_Lato,
            fontWeight = FontWeight(600),
            color = black
        )
        LinearProgressIndicator(
            progress = stepsDone.toFloat() / stepsTotal,
            modifier = Modifier
                .padding(top = 4.dp)
                .height(12.dp),
            color = Color(0xFFFCC46F),
            trackColor = Color(0xFFFCC46F).copy(.2f),
            strokeCap = StrokeCap.Round
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        LinearProgress(
            stepsTotal = 2000,
            stepsDone = 999
        )
    }
}
