package br.com.fiap.jokenpo.ui.spash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.fiap.jokenpo.R
import br.com.fiap.jokenpo.ui.main.MainActivity

class SpashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long=3000 // 3 sec

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)

        Handler().postDelayed({
            val intentNextScreen = Intent(this, MainActivity::class.java)
            startActivity(intentNextScreen)
            finish()
        }, SPLASH_TIME_OUT)

    }
}
