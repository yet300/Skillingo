package ru.hadj.skillingo.uikit.utils

import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.char


val dateTimeFormat = DateTimeComponents.Format {
    year(); char('-'); monthNumber(); char('-'); dayOfMonth()
    char(' ')
    hour(); char(':'); minute(); char(':'); second()
}

val timeFormat = DateTimeComponents.Format {
    minute(); char(':'); second()
}


fun formatTime(hours: Int, minutes: Int): String {
    return "${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}"
}