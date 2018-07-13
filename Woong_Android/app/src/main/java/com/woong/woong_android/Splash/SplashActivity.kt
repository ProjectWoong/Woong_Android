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
import com.woong.woong_android.SharedReferenceController
import com.woong.woong_android.tutorial.TutorialActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val rabbit = findViewById<View>(R.id.gif_image) as ImageView
        val gifImage = GlideDrawableImageViewTarget(rabbit)
        Glide.with(this).load<Any>(R.drawable.android_ssplash).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(gifImage)


        val handler = Handler()
        handler.postDelayed({
            if(SharedReferenceController.getFlag(this)==0){
                //튜토리얼 보여주기
                startActivity(Intent(applicationContext,TutorialActivity::class.java))
                SharedReferenceController.setFlag(this,1) //튜토리얼이 끝나는 부분에 집어넣기
                finish()

            }else{
                //로그인으로 바로 넘어가기 (한번 이앱을 켜서 튜토리얼을 본 이상)
                startActivity(Intent(applicationContext, LoginActivity::class.java))
                finish()
            }


        }, 3100) // 밀리세컨드=초*1000
    }
}
