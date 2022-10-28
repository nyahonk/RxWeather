package com.nyahonk.rxweather.ui.history_screen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.nyahonk.rxweather.models.WeatherVO
import com.nyahonk.rxweather.ui.base.BaseViewModel
import com.nyahonk.rxweather.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HistoryScreenViewModel @Inject constructor(
    weatherUseCase: WeatherUseCase
) : BaseViewModel() {

    val liveData = MutableLiveData<List<WeatherVO>>()

    init {
        disposables.add(
            weatherUseCase.getSearchHistory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        liveData.value = it
                    }, {
                        Log.e(this@HistoryScreenViewModel::class.simpleName, it.message ?: "db error")
                    })
        )
    }
}