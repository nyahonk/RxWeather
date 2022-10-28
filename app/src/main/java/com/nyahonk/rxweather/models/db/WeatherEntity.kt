package com.nyahonk.rxweather.models.db

import androidx.room.Entity

@Entity(tableName = "cities", primaryKeys = ["cityName", "countryName"])
data class WeatherEntity(
    val cityName: String,
    val countryName: String,
    val dateTime: Long,
    val currentTemp: Double,
    val minTemp: Double,
    val maxTemp: Double,
    val feelsLikeTemp: Double,
    val icon: String,
    val description: String
)
