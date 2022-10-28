package com.nyahonk.rxweather.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nyahonk.rxweather.models.db.WeatherEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface CitiesWeatherDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(weatherEntity: WeatherEntity)

    @Query("SELECT * FROM cities WHERE cityName = :cityName")
    fun getCachedCityWeather(cityName: String): WeatherEntity

    @Query("SELECT * FROM cities")
    fun getCachedCities(): Single<List<WeatherEntity>>
}