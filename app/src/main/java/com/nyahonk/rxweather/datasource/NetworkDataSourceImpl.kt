package com.nyahonk.rxweather.datasource

import com.nyahonk.rxweather.datasource.api.WeatherApi
import com.nyahonk.rxweather.models.network.WeatherResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val api: WeatherApi
): NetworkDataSource {

    override fun getWeatherData(cityName: String): Single<WeatherResponse> {
        return api.getWeatherData(cityName)
    }
}