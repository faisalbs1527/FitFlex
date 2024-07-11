package com.example.fitflex.presentation.analytics

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.components.DateBox
import com.example.fitflex.model.CalendarDataSource
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.black
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AnalyticsScreen() {
    AnalyticScreenSkeleton()
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AnalyticScreenSkeleton() {
    val currentDate = LocalDate.now()
    val dataSource = CalendarDataSource()
    val dates = dataSource.getData()

    var selectedDate by remember { mutableStateOf(currentDate) }

    val initialIndex = dates.indexOf(currentDate)
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = initialIndex)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 30.dp)
    ) {
        Text(
            text = dataSource.getYearMonth(),
            fontFamily = Font_Lato,
            fontSize = 18.sp,
            fontWeight = FontWeight(700),
            color = black
        )
        LazyRow(
            state = listState,
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(dates) { date ->
                DateBox(
                    onClick = { clickedDate ->
                        selectedDate = clickedDate
                    },
                    isSelected = date == selectedDate,
                    date = date
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        AnalyticScreenSkeleton()
    }
}

