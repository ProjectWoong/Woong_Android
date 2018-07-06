package com.woong.woong_android.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.Join.Consumer.TermsActivity
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_consumer_login.*

class ConsumerLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_login)

        btn_login_consumer_login.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)    // getActivity: 현재 액티비티를 가져옴
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
        tv_signup_consumer_login.setOnClickListener {
            val intent = Intent(applicationContext, TermsActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
    }
}