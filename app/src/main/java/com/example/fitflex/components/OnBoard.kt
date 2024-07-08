package com.example.fitflex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.R
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.almostOpaqueColor
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.gray
import com.example.fitflex.ui.theme.transparentColor
import com.example.fitflex.utils.OnBoardingPage

@Composable
fun PagerScreen(
    onBoardingPage: OnBoardingPage
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = onBoardingPage.image),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7F)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp) // Adjust height as needed
                        .align(Alignment.BottomCenter)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    transparentColor,
                                    almostOpaqueColor
                                ), // Or any color
                                startY = 0f,
                                endY = 220f // Adjust endY based on gradient height
                            )
                        )
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = onBoardingPage.tittle,
                fontSize = 24.sp,
                fontWeight = FontWeight(800),
                textAlign = TextAlign.Center,
                color = black,
                fontFamily = Font_LatoBold
            )
            Text(
                text = onBoardingPage.description,
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.padding(top = 8.dp),
                color = gray,
                fontFamily = Font_Lato,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowScreen() {
    FitFlexTheme {
        PagerScreen(
            onBoardingPage = OnBoardingPage.First
        )
    }
}
