package com.woong.woong_android.map

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_join_location_search.*

class LocationSearchActivity : AppCompatActivity() {

    lateinit var locationSearchItems : ArrayList<LocationSearchItem>
    lateinit var locationSearchAdapter : LocationSearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_location_search)

        btn_back_join_location_search.setOnClickListener {
            val intent = Intent(applicationContext, MapActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }

        locationSearchItems = ArrayList()
        locationSearchItems.add(LocationSearchItem("마포구 상수동 72-1", "와우산로 94"))

        locationSearchAdapter = LocationSearchAdapter(locationSearchItems)
        rv_result_consumer_location_search.layoutManager = LinearLayoutManager(this)
        rv_result_consumer_location_search.adapter = locationSearchAdapter
    }
}
