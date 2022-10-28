package com.nyahonk.rxweather.datasource

import com.nyahonk.rxweather.db.CitiesWeatherDAO
import com.nyahonk.rxweather.models.db.WeatherEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DataBaseDataSourceImpl @Inject constructor(
    private val citiesWeatherDAO: CitiesWeatherDAO
) : DataBaseDataSource {

    override fun updateWeatherData(weatherEntity: WeatherEntity) {
        citiesWeatherDAO.insertCity(weatherEntity)
    }

    override fun getCachedWeatherData(cityName: String): WeatherEntity {
        return citiesWeatherDAO.getCachedCityWeather(cityName)
    }

    override fun getCachedCitiesList(): Single<List<WeatherEntity>> {
        return citiesWeatherDAO.getCachedCities()
    }
}