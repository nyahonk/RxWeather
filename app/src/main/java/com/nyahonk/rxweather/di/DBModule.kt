package com.nyahonk.rxweather.di

import android.content.Context
import androidx.room.Room
import com.nyahonk.rxweather.db.CitiesWeatherDAO
import com.nyahonk.rxweather.db.WeatherDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {

    @Provides
    @Singleton
    fun provideWeatherDB(@ApplicationContext appContext: Context): WeatherDataBase = Room.databaseBuilder(
        appContext,
        WeatherDataBase::class.java, "WeatherDataBase"
    ).build()

    @Provides
    fun provideCitiesWeatherDAO(db: WeatherDataBase): CitiesWeatherDAO = db.citiesWeatherDAO()
}