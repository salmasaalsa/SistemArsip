package com.example.sistemarsip

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var  l1 = findViewById<LinearLayout>(R.id.l1)
        var l2 = findViewById<LinearLayout>(R.id.l2)
        var uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown)
        var downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup)
        l1.animation = uptodown
        l2.animation = downtoup
        buttonsub.setOnClickListener {
            startActivity(Intent(this, ActivityHomeScreen::class.java))
        }
    }
}