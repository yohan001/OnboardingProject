package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {

    var iv_splash_screen_logo : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        iv_splash_screen_logo = findViewById(R.id.iv_splash_screen_logo)
        iv_splash_screen_logo?.alpha = 0f
        iv_splash_screen_logo?.animate()?.setDuration(1500)?.alpha(1f)?.withEndAction {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}