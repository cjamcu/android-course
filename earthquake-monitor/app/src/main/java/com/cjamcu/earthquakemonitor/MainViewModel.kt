package com.cjamcu.earthquakemonitor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val _eqList = MutableLiveData<MutableList<Earthquake>>()


    val eqList: LiveData<MutableList<Earthquake>>
        get() = _eqList


    init {
        viewModelScope.launch {
            _eqList.value = fetchEarthquakes()

        }
    }

    private suspend fun fetchEarthquakes(): MutableList<Earthquake> {
        return withContext(Dispatchers.IO) {
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
            eqList


        }

    }


}