package br.com.fiap.jokenpo.ui.player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.jokenpo.R
import br.com.fiap.jokenpo.ui.game.GameActivity
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        ivBack.setOnClickListener {
            onBackPressed()
        }

        btStartGame.setOnClickListener {
            val intentNextScreen = Intent(this, GameActivity::class.java)
            intentNextScreen.putExtra("player_name", inputPlayer.text.toString())
            startActivity(intentNextScreen)
        }
    }
}
