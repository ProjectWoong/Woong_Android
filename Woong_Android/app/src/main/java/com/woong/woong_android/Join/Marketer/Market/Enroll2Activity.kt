package com.woong.woong_android.join.marketer.market

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_market_enroll2.*

class Enroll2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_enroll2)

        val spnBank = findViewById(R.id.spinner_bank) as Spinner
        val adapterBank = ArrayAdapter.createFromResource(this, R.array.bank, android.R.layout.simple_spinner_item)
        spnBank.adapter = adapterBank

        question1.setOnClickListener {
            answer1.visibility = View.VISIBLE
        }

        question2.setOnClickListener {
            answer2.visibility = View.VISIBLE
        }

        btn_cancel1_enroll2.setOnClickListener {
            answer1.visibility = View.INVISIBLE
        }

        btn_cancel2_enroll2.setOnClickListener {
            answer2.visibility = View.INVISIBLE
        }

        btn_complete_enroll2.setOnClickListener {
            val intent = Intent(applicationContext, Enroll3Activity::class.java)
            startActivity(intent)
        }
    }
}
