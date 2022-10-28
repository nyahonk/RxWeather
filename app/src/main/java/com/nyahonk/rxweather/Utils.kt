package com.nyahonk.rxweather

import java.text.SimpleDateFormat
import java.util.*

object Utils {

    private val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.ENGLISH).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }

    fun buildImgUrl(iconName: String) = "https://openweathermap.org/img/wn/${iconName}@4x.png"

    fun convertEpochToDateTime(epoch: Long): String {
        //api return epoch time in seconds and we need to convert it to milliseconds
        //for Date class to parse it correctly
        val date = Date(epoch * 1000)
        return sdf.format(date)
    }

    fun convertCelsiusToFahrenheit(celsius: Double) = (celsius - 32.0) * 5.0 / 9.0

}