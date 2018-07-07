package com.woong.woong_android.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_consumer_login.setOnClickListener {
            val intent = Intent(applicationContext, ConsumerLoginActivity::class.java)
            startActivity(intent)
        }
        btn_marketer_login.setOnClickListener {
            val intent = Intent(applicationContext, MarketerLoginActivity::class.java)
            startActivity(intent)
        }
    }

}
