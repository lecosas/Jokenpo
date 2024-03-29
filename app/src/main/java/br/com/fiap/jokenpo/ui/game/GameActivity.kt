package br.com.fiap.jokenpo.ui.game

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.fiap.jokenpo.R
import kotlinx.android.synthetic.main.activity_game.*


class GameActivity : AppCompatActivity() {

    private lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        setupView()
        registerObserver()

        ivPapelPlay.setOnClickListener {

            Handler().postDelayed({
                ivPlayerPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.papel))
                gameViewModel.play(0)
            }, 2000)

        }

        ivPedraPlay.setOnClickListener {
            ivPlayerPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pedra))
            gameViewModel.play(1)
        }

        ivTesouraPlay.setOnClickListener {
            ivPlayerPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.tesoura))
            gameViewModel.play(2)
        }

    }

    private fun registerObserver() {
        gameViewModel.playerPoints.observe(this, Observer {
            tvPlayerResult.text = it.toString()
        })

        gameViewModel.androidPoints.observe(this, Observer {
            tvAndroidResult.text = it.toString()
        })

        gameViewModel.partialResult.observe(this, Observer {
            when (it.toInt()) {
                0 -> {
                    tvWhoWin.text = tvPlayerName.text.toString() + " is the Champion"
                }
                1 -> {
                    tvWhoWin.text = "Android is the Champion!"
                }
            }
        })

        gameViewModel.partialResult.observe(this, Observer {
            when (it.toInt()) {
                0 -> tvWhoWin.text = tvPlayerName.text.toString() + " Win!"
                1 -> tvWhoWin.text = "Android Win!"
                2 -> tvWhoWin.text = "It's a Draw"
            }
        })

        gameViewModel.androidPlay.observe(this, Observer {
            when (it.toInt()) {
                0 -> ivAndroidPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.papel))
                1 -> ivAndroidPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pedra))
                2 -> ivAndroidPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.tesoura))
            }
        })

    }

    private fun setupView() {
        val playerName = intent.getStringExtra("player_name")
        tvPlayerName.text = playerName
    }

}


