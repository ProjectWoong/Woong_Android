package com.woong.woong_android.join.marketer.market

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.woong.woong_android.R
import com.woong.woong_android.map.LocationSearchAdapter
import com.woong.woong_android.map.LocationSearchItem
import kotlinx.android.synthetic.main.activity_enroll1_search.*

class Enroll1SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enroll1_search)

        lateinit var locationSearchItems : ArrayList<LocationSearchItem>
        lateinit var locationSearchAdapter : LocationSearchAdapter

        btn_back_market_location_search.setOnClickListener {
            val intent = Intent(applicationContext, Enroll1Activity::class.java)
            startActivity(intent)
        }

        locationSearchItems = ArrayList()
        locationSearchItems.add(LocationSearchItem("마포구 상수동 72-1", "와우산로 94"))

        locationSearchAdapter = LocationSearchAdapter(locationSearchItems)
        rv_result_location_search.layoutManager = LinearLayoutManager(this)
        rv_result_location_search.adapter = locationSearchAdapter
    }
}
