package com.woong.woong_android.Join.Consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_consumer_terms.*

class TermsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_terms)

        btn_next_terms.setOnClickListener {
            val intent = Intent(applicationContext, Join1Activity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
    }
}
