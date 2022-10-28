package com.nyahonk.rxweather.usecase

import com.nyahonk.rxweather.Utils
import com.nyahonk.rxweather.models.WeatherVO
import com.nyahonk.rxweather.models.db.WeatherEntity
import com.nyahonk.rxweather.repository.DataRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeatherUseCaseImpl @Inject constructor(
    private val dataRepository: DataRepository
) : WeatherUseCase {

    override fun getWeatherData(cityName: String): Single<WeatherVO> {
        return dataRepository.getWeatherData(cityName).map { mapWeatherEntityToVO(it) }
    }

    override fun getSearchHistory(): Single<List<WeatherVO>> {
        return dataRepository.getSearchHistory().map { list ->
            list.map { mapWeatherEntityToVO(it) }.reversed()
        }
    }

    private fun mapWeatherEntityToVO(entity: WeatherEntity) = WeatherVO(
        cityName = entity.cityName,
        countryName = entity.countryName,
        dateTime = Utils.convertEpochToDateTime(entity.dateTime),
        currentTemp = entity.currentTemp.toString(),
        minTemp = entity.minTemp.toString(),
        maxTemp = entity.maxTemp.toString(),
        feelsLikeTemp = entity.feelsLikeTemp.toString(),
        icon = Utils.buildImgUrl(entity.icon),
        description = entity.description
    )

}