package com.nyahonk.rxweather.di

import com.nyahonk.rxweather.datasource.DataBaseDataSource
import com.nyahonk.rxweather.datasource.DataBaseDataSourceImpl
import com.nyahonk.rxweather.datasource.NetworkDataSource
import com.nyahonk.rxweather.datasource.NetworkDataSourceImpl
import com.nyahonk.rxweather.repository.DataRepository
import com.nyahonk.rxweather.repository.DataRepositoryImpl
import com.nyahonk.rxweather.usecase.WeatherUseCase
import com.nyahonk.rxweather.usecase.WeatherUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindNetworkDataSource(
        networkDataSourceImpl: NetworkDataSourceImpl
    ): NetworkDataSource

    @Binds
    abstract fun bindDataBaseDataSource(
        dataBaseDataSourceImpl: DataBaseDataSourceImpl
    ): DataBaseDataSource

    @Binds
    abstract fun bindDataRepository(
        dataRepositoryImpl: DataRepositoryImpl
    ): DataRepository

    @Binds
    abstract fun bindWeatherUseCase(
        weatherUseCaseImpl: WeatherUseCaseImpl
    ): WeatherUseCase
}