package com.nyahonk.rxweather.models.network


import com.squareup.moshi.Json

data class Wind(
    @Json(name = "deg")
    val deg: Int,
    @Json(name = "speed")
    val speed: Double
)