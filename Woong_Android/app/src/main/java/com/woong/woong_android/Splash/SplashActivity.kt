package com.woong.woong_android.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.woong.woong_android.login.LoginActivity
import com.woong.woong_android.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            //
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }, 3000) // 밀리세컨드=초*1000
    }
}
