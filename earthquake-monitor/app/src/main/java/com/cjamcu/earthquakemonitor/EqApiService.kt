package com.cjamcu.earthquakemonitor

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface EqApiService {
    @GET("all_hour.geojson")
    suspend fun getLastHourEarthquakes() : EqResponse
}

private var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

var service = retrofit.create(EqApiService::class.java)