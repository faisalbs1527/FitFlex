package com.example.fitflex.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
class CalendarDataSource {
    val currentDate = LocalDate.now()

    fun getData(): List<LocalDate> {
        val yearMonth = YearMonth.from(currentDate)
        val daysInMonth = yearMonth.lengthOfMonth()
        val dates = (1..daysInMonth).map { yearMonth.atDay(it) }
        return dates
    }

    fun getYearMonth(): String {
        val monthYear = DateTimeFormatter.ofPattern("MMM, yyyy")
        val monthYearString = currentDate.format(monthYear)
        return monthYearString
    }
}

