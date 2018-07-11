package com.woong.woong_android.join.consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.R
import com.woong.woong_android.map.MapActivity
import kotlinx.android.synthetic.main.activity_consumer_join_allergy.*


class AllergyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_join_allergy)
        var birth = intent.getStringExtra("birth")
        var name = intent.getStringExtra("name")
        var email = intent.getStringExtra("email")
        var pwd = intent.getStringExtra("pwd")
        var phone = intent.getStringExtra("phone")

        btn_complete_allergy.setOnClickListener {
            val intent = Intent(applicationContext, MapActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
    }
}
