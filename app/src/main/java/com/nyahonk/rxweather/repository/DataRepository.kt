package com.nyahonk.rxweather.repository

import com.nyahonk.rxweather.models.db.WeatherEntity
import io.reactivex.rxjava3.core.Single

interface DataRepository {

    fun getWeatherData(cityName: String): Single<WeatherEntity>

    fun getSearchHistory():  Single<List<WeatherEntity>>
}