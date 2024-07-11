package com.example.fitflex.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.lightGreen
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateBox(
    onClick: (LocalDate) -> Unit,
    isSelected: Boolean,
    date: LocalDate
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .clickable {
                    onClick(date)
                },
            colors = CardDefaults.cardColors(
                containerColor = if (isSelected) black
                else lightGreen
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(45.dp)
                    .height(48.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = date.format(DateTimeFormatter.ofPattern("E")),
                    fontFamily = Font_Lato,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    color = if (isSelected) Color.White
                    else black
                )
                Text(
                    text = date.dayOfMonth.toString(),
                    fontFamily = Font_Lato,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    color = if (isSelected) Color.White
                    else black
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 4.dp)
                .size(6.dp)
                .background(
                    color = if (isSelected) black else Color.Transparent,
                    shape = CircleShape
                )
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        val currentDate = LocalDate.now()
        DateBox(onClick = {}, false, currentDate)
    }
}