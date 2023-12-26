package com.cjamcu.basketballscore

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var localScore = 0
    var visitorScore = 0

    fun resetScore(){
        localScore = 0
        visitorScore = 0
    }

    fun addPointsToScore(points: Int, isLocal: Boolean){
        if (isLocal){
            localScore += points
        }else{
            visitorScore += points
        }
    }

    fun minusPointsToScore(points: Int, isLocal: Boolean){
        if (isLocal){
            if (localScore > 0){
                localScore -= points
            }
        }else{
            if (visitorScore > 0){
                visitorScore -= points
            }
        }
    }

}