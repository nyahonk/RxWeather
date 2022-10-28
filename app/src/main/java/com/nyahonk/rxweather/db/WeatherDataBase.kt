package com.nyahonk.rxweather.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nyahonk.rxweather.models.db.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1)
abstract class WeatherDataBase : RoomDatabase() {
    abstract fun citiesWeatherDAO(): CitiesWeatherDAO
}