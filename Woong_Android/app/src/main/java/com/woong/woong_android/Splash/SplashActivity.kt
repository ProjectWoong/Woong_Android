package com.woong.woong_android.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.woong.woong_android.login.LoginActivity
import com.woong.woong_android.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget



class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val rabbit = findViewById<View>(R.id.gif_image) as ImageView
        val gifImage = GlideDrawableImageViewTarget(rabbit)
        Glide.with(this).load<Any>(R.drawable.android_ssplash).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(gifImage)


        val handler = Handler()
        handler.postDelayed({
            //
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }, 3100) // 밀리세컨드=초*1000
    }
}
