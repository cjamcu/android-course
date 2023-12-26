package com.cjamcu.earthquakemonitor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _eqList =  MutableLiveData<MutableList<Earthquake>>()

    val eqList: LiveData<MutableList<Earthquake>>
        get() = _eqList


    init {
        fetchEarthquakes()
    }

    private fun fetchEarthquakes() {
       val  eqList = mutableListOf<Earthquake>()
        eqList.add(Earthquake("1", "New York", 4.3, 1634178860, -73.9, 40.7))
        eqList.add(Earthquake("2", "La Habana", 3.2, 1634178860, -82.4, 23.1))
        eqList.add(Earthquake("3", "Santiago de Chile", 5.1, 1634178860, -70.6, -33.4))
        eqList.add(Earthquake("4", "Buenos Aires", 2.3, 1634178860, -58.4, -34.6))
        eqList.add(Earthquake("5", "Lima", 4.9, 1634178860, -77.0, -12.0))
        eqList.add(Earthquake("6", "Bogotá", 3.7, 1634178860, -74.1, 4.6))
        eqList.add(Earthquake("7", "Caracas", 4.5, 1634178860, -66.9, 10.5))
        eqList.add(Earthquake("8", "Quito", 3.1, 1634178860, -78.5, -0.2))
        eqList.add(Earthquake("9", "Montevideo", 2.8, 1634178860, -56.2, -34.9))

        _eqList.value = eqList
    }
}