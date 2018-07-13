package com.woong.woong_android.tutorial

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.R
import com.woong.woong_android.login.LoginActivity
import kotlinx.android.synthetic.main.activity_tutorial_end.*

class TutorialEndActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_end)
        btn_start_tutorial4.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
