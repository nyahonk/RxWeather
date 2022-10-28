package com.nyahonk.rxweather.models.network


import com.squareup.moshi.Json

data class Clouds(
    @Json(name = "all")
    val all: Int
)