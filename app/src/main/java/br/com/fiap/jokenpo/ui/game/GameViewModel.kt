package br.com.fiap.jokenpo.ui.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel : ViewModel() {

    val playerPoints = MutableLiveData<Int>()
    val androidPoints = MutableLiveData<Int>()
    val androidPlay = MutableLiveData<Int>()

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
                } else if (playPlayer == 2) {
                    playerPoints.value = playerPoints.value?.plus(1)
                }
            }
            1 -> {
                if (playPlayer == 0) {
                    playerPoints.value = playerPoints.value?.plus(1)
                } else if (playPlayer == 2) {
                    androidPoints.value = androidPoints.value?.plus(1)
                }
            }
            2 -> {
                if (playPlayer == 0) {
                    androidPoints.value = androidPoints.value?.plus(1)
                } else if (playPlayer == 1) {
                    playerPoints.value = playerPoints.value?.plus(1)
                }
            }
        }

        //if (playerPoints.value  >= 2 || androidPoints.value >= 2 ) {
            //termina o jogo
        //}
    }




}