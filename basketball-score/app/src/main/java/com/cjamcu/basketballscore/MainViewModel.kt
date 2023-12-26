package com.cjamcu.basketballscore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _localScore: MutableLiveData<Int> = MutableLiveData()
    private var _visitorScore: MutableLiveData<Int> = MutableLiveData()

    val localScore: LiveData<Int>
        get() = _localScore

    val visitorScore: LiveData<Int>
        get() = _visitorScore

    fun resetScore() {
        _localScore.value = 0
        _visitorScore.value = 0
    }

    init {
        resetScore()
    }

    fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            _localScore.value = _localScore.value?.plus(points)
        } else {
            _visitorScore.value = _visitorScore.value?.plus(points)
        }
    }

    fun minusPointsToScore(points: Int, isLocal: Boolean) {

        if (isLocal && _localScore.value == 0) {
            return
        }

        if (!isLocal && _visitorScore.value == 0) {
            return
        }


        if (isLocal) {

            _localScore.value = _localScore.value!!.minus(points)

        } else {

            _visitorScore.value = _visitorScore.value!!.minus(points)

        }
    }

}