package com.nyahonk.rxweather.datasource

import com.nyahonk.rxweather.models.db.WeatherEntity
import io.reactivex.rxjava3.core.Single

interface DataBaseDataSource {

    fun updateWeatherData(weatherEntity: WeatherEntity)

    fun getCachedWeatherData(cityName: String): WeatherEntity

    fun getCachedCitiesList(): Single<List<WeatherEntity>>
}