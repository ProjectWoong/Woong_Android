package com.woong.woong_android.Splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            //
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }, 3000) // 밀리세컨드=초*1000
    }
}
