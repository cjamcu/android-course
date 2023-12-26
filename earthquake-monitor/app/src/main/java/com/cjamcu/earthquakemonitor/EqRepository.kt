package com.cjamcu.earthquakemonitor

class EqRepository {
    suspend  fun  fetchEarthquakes() : MutableList<Earthquake>{
        val response: EqResponse = service.getLastHourEarthquakes()

        val eqList = mutableListOf<Earthquake>()
        response.features.forEach {
            eqList.add(
                Earthquake(
                    it.id,
                    it.properties.place,
                    it.properties.mag,
                    it.properties.time,
                    it.geometry.longitude,
                    it.geometry.latitude
                )
            )
        }
        return eqList
    }
}