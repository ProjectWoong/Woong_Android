package com.woong.woong_android.Join.Marketer.Market

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_market_enroll1.*
import net.daum.mf.map.api.MapView

class Enroll1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_enroll1)

        val mapView = MapView(this)
        mapView.setDaumMapApiKey("5b9f84f71895898003a9683274d06a39")
        val container = findViewById<View>(R.id.map_view) as RelativeLayout

        container.addView(mapView)

        btn_next_enroll1.setOnClickListener {
            val intent = Intent(applicationContext, Enroll2Activity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }

        farm_location_confirm.setOnClickListener {
            val intent = Intent(applicationContext, Enroll1SearchActivity::class.java)
            startActivity(intent)
        }
    }
}
