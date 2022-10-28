package com.nyahonk.rxweather.ui.main_screen

import androidx.lifecycle.MutableLiveData
import com.nyahonk.rxweather.models.WeatherVO
import com.nyahonk.rxweather.ui.base.BaseViewModel
import com.nyahonk.rxweather.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
) : BaseViewModel() {

    var cityName: String  = ""
    val liveData = MutableLiveData<WeatherVO>()
    val errorLiveData = MutableLiveData<String?>()

    fun requestData() {
        disposables.add(
            weatherUseCase.getWeatherData(cityName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    liveData.value = it
                    errorLiveData.value = null
                }, {
                    errorLiveData.value = it.message ?: "network error"
                })
        )
    }
}