package com.nyahonk.rxweather.ui.main_screen

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.google.android.material.snackbar.Snackbar
import com.nyahonk.rxweather.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainScreenViewModel by activityViewModels()

    private lateinit var locationTV: TextView
    private lateinit var dateTV: TextView
    private lateinit var currentTempTV: TextView
    private lateinit var iconIV: ImageView
    private lateinit var minTempTV: TextView
    private lateinit var maxTempTV: TextView
    private lateinit var feelsLikeTempTV: TextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationTV = view.findViewById(R.id.fragment_main_location_text)
        dateTV = view.findViewById(R.id.fragment_main_date_text)
        currentTempTV = view.findViewById(R.id.fragment_main_weather_temp)
        iconIV = view.findViewById(R.id.fragment_main_weather_image)
        minTempTV = view.findViewById(R.id.fragment_main_weather_temp_extra_min_text)
        maxTempTV = view.findViewById(R.id.fragment_main_weather_temp_extra_max_text)
        feelsLikeTempTV = view.findViewById(R.id.fragment_main_weather_temp_extra_feels_text)

        viewModel.liveData.observe(viewLifecycleOwner) {
            locationTV.text = "${it.cityName}, ${it.countryName}"
            dateTV.text = it.dateTime
            currentTempTV.text = it.currentTemp
            iconIV.load(it.icon)
            minTempTV.text = it.minTemp
            maxTempTV.text = it.maxTemp
            feelsLikeTempTV.text = it.maxTemp
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) { errorMessage ->
            errorMessage?.let { Snackbar.make(requireView(), it, Snackbar.LENGTH_SHORT).show() }
        }
    }
}