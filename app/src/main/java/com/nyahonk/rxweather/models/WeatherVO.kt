package com.nyahonk.rxweather.models

data class WeatherVO(
    val cityName: String,
    val countryName: String,
    val dateTime: String,
    val currentTemp: String,
    val minTemp: String,
    val maxTemp: String,
    val feelsLikeTemp: String,
    val icon: String,
    val description: String
)
