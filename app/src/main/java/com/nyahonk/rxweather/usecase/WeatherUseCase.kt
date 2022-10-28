package com.nyahonk.rxweather.usecase

import com.nyahonk.rxweather.models.WeatherVO
import io.reactivex.rxjava3.core.Single

interface WeatherUseCase {

    fun getWeatherData(cityName: String): Single<WeatherVO>

    fun getSearchHistory(): Single<List<WeatherVO>>
}