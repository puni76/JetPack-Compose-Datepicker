package com.example.datepicker.util

import android.annotation.SuppressLint
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

@SuppressLint("NewApi")
internal fun LocalDate.getNextDates(count: Int): List<LocalDate> {
    val dates = mutableListOf<LocalDate>()
    repeat(count) { day ->
        dates.add(this.plusDays((day).toLong()))
    }
    return dates
}

/**
 * @return week start date - default monday
 */
@SuppressLint("NewApi")
internal fun LocalDate.getWeekStartDate(weekStartDay: DayOfWeek = DayOfWeek.MONDAY): LocalDate {
    var date = this
    while (date.dayOfWeek != weekStartDay) {
        date = date.minusDays(1)
    }
    return date
}

/**
 * @return list of dates remaining in the week
 */
@SuppressLint("NewApi")
internal fun LocalDate.getRemainingDatesInWeek(weekStartDay: DayOfWeek = DayOfWeek.MONDAY): List<LocalDate> {
    val dates = mutableListOf<LocalDate>()
    var date = this.plusDays(1)
    while (date.dayOfWeek != weekStartDay) {
        dates.add(date)
        date = date.plusDays(1)
    }
    return dates
}

/**
 * @return list of dates remaining in the month
 */
@SuppressLint("NewApi")
internal fun LocalDate.getRemainingDatesInMonth(): List<LocalDate> {
    val dates = mutableListOf<LocalDate>()
    repeat(this.month.length(this.isLeapYear) - this.dayOfMonth + 1) {
        dates.add(this.plusDays(it.toLong()))
    }
    return dates
}

/**
 * @return YearMonth object of given date
 */
@SuppressLint("NewApi")
internal fun LocalDate.yearMonth(): YearMonth = YearMonth.of(this.year, this.month)

