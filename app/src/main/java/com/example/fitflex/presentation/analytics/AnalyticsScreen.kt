package com.example.fitflex.presentation.analytics

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.fitflex.components.CircularProgress
import com.example.fitflex.components.ContentBox
import com.example.fitflex.components.DateBox
import com.example.fitflex.components.Header
import com.example.fitflex.components.LinearProgress
import com.example.fitflex.components.SubTitle
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.black
import com.example.fitflex.utils.CalendarDataSource
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AnalyticsScreen(padding: PaddingValues) {
    AnalyticScreenSkeleton(padding)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AnalyticScreenSkeleton(padding: PaddingValues) {
    val currentDate = LocalDate.now()
    val dataSource = CalendarDataSource()
    val dates = dataSource.getData()

    var selectedDate by remember { mutableStateOf(currentDate) }


    val initialIndex = dates.indexOf(currentDate.minusDays(dataSource.findPosition().toLong()))
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = initialIndex)


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 30.dp)
                .verticalScroll(
                    state = rememberScrollState()
                )
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
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
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
            SubTitle(text = "Today Report")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(.33f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ContentBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                        color = Color.White,
                        header = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Active calories",
                                    fontSize = 13.sp,
                                    fontFamily = Font_Lato,
                                    fontWeight = FontWeight(500),
                                    color = black.copy(.5f)
                                )
                            }
                        }) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "645 Cal",
                                fontSize = 16.sp,
                                fontFamily = Font_LatoBold,
                                fontWeight = FontWeight(800),
                                color = black
                            )
                        }
                    }

                    ContentBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(132.dp),
                        color = Color(0xFFEAECFF),
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

                ContentBox(
                    modifier = Modifier
                        .fillMaxWidth(.94f)
                        .height(218.dp),
                    color = black, header = {
                        Header(
                            icon = R.drawable.ic_cycling,
                            color = Color.White,
                            text = "Cycling",
                            textColor = Color.White
                        )
                    }) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(146.dp)
                            .padding(top = 4.dp, end = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.map), contentDescription = "",
                            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ContentBox(
                    modifier = Modifier
                        .fillMaxWidth(.55f)
                        .height(167.dp),
                    color = Color(0xFFFFEBEB), header = {
                        Header(
                            icon = R.drawable.ic_heart,
                            color = Color(0xFFF9B9B9),
                            text = "Heart Rate",
                            textColor = black
                        )
                    }) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(91.dp)
                            .padding(top = 4.dp, end = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.graph),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(.9f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ContentBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        color = Color(0xFFFFE8C6),
                        header = {
                            Header(
                                icon = R.drawable.ic_step,
                                color = Color(0xFFF8D39D),
                                text = "Steps",
                                textColor = black
                            )
                        }) {
                        LinearProgress(stepsTotal = 2000, stepsDone = 999)
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(51.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6CFCF))
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Keep it Up! \uD83D\uDCAA",
                                fontSize = 16.sp,
                                fontFamily = Font_LatoBold,
                                fontWeight = FontWeight(600),
                                color = black
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, end = 20.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ContentBox(
                    modifier = Modifier
                        .fillMaxWidth(.5f)
                        .height(128.dp),
                    color = Color(0xFFEFE2FF), header = {
                        Header(
                            icon = R.drawable.ic_sleep,
                            color = Color(0xFFD6BBF8),
                            text = "Sleep",
                            textColor = black
                        )
                    }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(top = 4.dp, end = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bar), contentDescription = "",
                            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
                        )
                    }
                }
                ContentBox(
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .height(128.dp),
                    color = Color(0xFFD8E6EC), header = {
                        Header(
                            icon = R.drawable.ic_water,
                            color = Color(0xFF95CCE3),
                            text = "Water",
                            textColor = black
                        )
                    }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(top = 4.dp, end = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.water),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        AnalyticScreenSkeleton(PaddingValues(0.dp))
    }
}

