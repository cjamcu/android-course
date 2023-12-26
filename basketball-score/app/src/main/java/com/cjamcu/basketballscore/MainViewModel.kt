package com.cjamcu.basketballscore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var localScore: MutableLiveData<Int> = MutableLiveData()
    var visitorScore: MutableLiveData<Int> = MutableLiveData()

    fun resetScore() {
        localScore.value = 0
        visitorScore.value = 0
    }

    init {
        resetScore()
    }

    fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            localScore.value = localScore.value?.plus(points)
        } else {
            visitorScore.value = visitorScore.value?.plus(points)
        }
    }

    fun minusPointsToScore(points: Int, isLocal: Boolean) {

        if (isLocal && localScore.value == 0) {
            return
        }

        if (!isLocal && visitorScore.value == 0) {
            return
        }


        if (isLocal) {

            localScore.value = localScore.value!!.minus(points)

        } else {

            visitorScore.value = visitorScore.value!!.minus(points)

        }
    }

}