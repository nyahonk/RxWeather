package com.nyahonk.rxweather.datasource.api

import com.nyahonk.rxweather.ApiKey
import com.nyahonk.rxweather.models.network.WeatherResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    fun getWeatherData(
        @Query("q") city: String = "Amsterdam",
        @Query("units") measuringUnits: String = UNIT_METRIC,
        @Query("appid") apiKey: String = ApiKey.API_KEY
    ): Single<WeatherResponse>

    companion object {
        const val UNIT_METRIC = "metric"
        const val UNIT_IMPERIAL = "imperial"
    }
}