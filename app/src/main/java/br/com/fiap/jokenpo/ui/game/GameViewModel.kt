package br.com.fiap.jokenpo.ui.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel : ViewModel() {

    val playerPoints = MutableLiveData<Int>()
    val androidPoints = MutableLiveData<Int>()
    val androidPlay = MutableLiveData<Int>()
    val partialResult = MutableLiveData<Int>()
    val finalResult = MutableLiveData<Int>()

    init {
        initGame()
    }

    private fun initGame() {
        playerPoints.value = 0
        androidPoints.value = 0
    }

    fun play(playPlayer: Int) {

        val random = Random.nextInt(3)
        androidPlay.value = random

        when(androidPlay.value){
            0 -> {
                if (playPlayer == 1) {
                    androidPoints.value = androidPoints.value?.plus(1)
                    partialResult.value = 1
                } else if (playPlayer == 2) {
                    playerPoints.value = playerPoints.value?.plus(1)
                    partialResult.value = 0
                } else {
                    partialResult.value = 2
                }
            }
            1 -> {
                if (playPlayer == 0) {
                    playerPoints.value = playerPoints.value?.plus(1)
                    partialResult.value = 0
                } else if (playPlayer == 2) {
                    androidPoints.value = androidPoints.value?.plus(1)
                    partialResult.value = 1
                } else {
                    partialResult.value = 2
                }
            }
            2 -> {
                if (playPlayer == 0) {
                    androidPoints.value = androidPoints.value?.plus(1)
                    partialResult.value = 1
                } else if (playPlayer == 1) {
                    playerPoints.value = playerPoints.value?.plus(1)
                    partialResult.value = 0
                } else {
                    partialResult.value = 2
                }
            }
        }

        if (playerPoints.value ?:0 >= 2) {
            finalResult.value = 0
        } else if (androidPoints.value ?:0  >= 2) {
            finalResult.value = 1
        }
    }




}