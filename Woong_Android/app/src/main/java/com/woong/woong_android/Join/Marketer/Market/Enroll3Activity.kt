package com.woong.woong_android.join.marketer.market

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.login.LoginActivity
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_market_enroll3.*

class Enroll3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_enroll3)
        btn_ok_enroll3.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
