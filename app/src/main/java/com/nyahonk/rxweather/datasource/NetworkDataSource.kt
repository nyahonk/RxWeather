package com.nyahonk.rxweather.datasource

import com.nyahonk.rxweather.models.network.WeatherResponse
import io.reactivex.rxjava3.core.Single

interface NetworkDataSource {

    fun getWeatherData(cityName: String): Single<WeatherResponse>

}