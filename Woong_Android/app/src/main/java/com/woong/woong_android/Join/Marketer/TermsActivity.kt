package com.woong.woong_android.join.marketer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_marketer_terms.*

class TermsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marketer_terms)

        btn_next_terms.setOnClickListener {
            val intent = Intent(applicationContext, Join1Activity::class.java)
            startActivity(intent)
        }
    }
}
