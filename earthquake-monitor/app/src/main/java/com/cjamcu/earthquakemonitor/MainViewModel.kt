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
    private val eqRepository = EqRepository()


    val eqList: LiveData<MutableList<Earthquake>>
        get() = _eqList


    init {
        viewModelScope.launch {
            val earthquakes = withContext(Dispatchers.IO) {
                eqRepository.fetchEarthquakes()
            }
            _eqList.value = earthquakes
        }
    }


}