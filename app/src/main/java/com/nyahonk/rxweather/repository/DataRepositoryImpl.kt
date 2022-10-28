package com.nyahonk.rxweather.repository

import com.nyahonk.rxweather.datasource.DataBaseDataSource
import com.nyahonk.rxweather.datasource.NetworkDataSource
import com.nyahonk.rxweather.models.db.WeatherEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val dbDataSource: DataBaseDataSource
) : DataRepository {

    override fun getWeatherData(cityName: String): Single<WeatherEntity> = networkDataSource.getWeatherData(cityName)
        .map {
            WeatherEntity(
                cityName = it.name,
                countryName = it.sys.country,
                dateTime = it.dt,
                currentTemp = it.main.temp,
                minTemp = it.main.tempMin,
                maxTemp = it.main.tempMax,
                feelsLikeTemp = it.main.feelsLike,
                icon = it.weather.first().icon,
                description = it.weather.first().description
            )
        }.doOnSuccess {
            dbDataSource.updateWeatherData(it)
        }

    override fun getSearchHistory() = dbDataSource.getCachedCitiesList()
}