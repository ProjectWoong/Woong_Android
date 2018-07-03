package com.woong.woong_android.Join.Consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_consumer_join1.*

class Join1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_join1)
        btn_next_join1.setOnClickListener {
            val intent = Intent(applicationContext, Join2Activity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
    }
}
