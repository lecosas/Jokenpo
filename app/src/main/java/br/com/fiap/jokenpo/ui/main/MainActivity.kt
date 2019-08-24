package br.com.fiap.jokenpo.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.jokenpo.R
import br.com.fiap.jokenpo.ui.about.AboutActivity
import br.com.fiap.jokenpo.ui.player.PlayerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btStartGame.setOnClickListener {
            val intentNextScreen = Intent(this, PlayerActivity::class.java)
            startActivity(intentNextScreen)
        }

        btFinishGame.setOnClickListener {
            finish()
        }

        tvAbout.setOnClickListener {
            val intentAboutScreen = Intent(this, AboutActivity::class.java)
            startActivity(intentAboutScreen)
        }

    }
}
