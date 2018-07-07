package com.woong.woong_android.map

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.woong.woong_android.R
import com.woong.woong_android.map.get.GetLocationListResponse
import com.woong.woong_android.map.get.GetLocationListResponseData
import com.woong.woong_android.network.NetworkService
import kotlinx.android.synthetic.main.activity_join_location_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager


class LocationSearchActivity : AppCompatActivity() {

    lateinit var locationSearchItems : ArrayList<GetLocationListResponseData>
    lateinit var locationSearchAdapter : LocationSearchAdapter
    lateinit var networkService: NetworkService
    lateinit var imm:InputMethodManager
    var header = "KakaoAK 865f5a39675526bdbdd0855cbc560e9b"
    var location_keyword=""
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_location_search)
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager //키보드 내리기위해서


        val builder = Retrofit.Builder()
        val retrofit_loc_search = builder
                .baseUrl("https://dapi.kakao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        networkService = retrofit_loc_search.create(NetworkService::class.java)
        rv_result_consumer_location_search.layoutManager = LinearLayoutManager(this)

        //if(btn_)
        et_search_main.setOnEditorActionListener { textView, i, keyEvent ->
            when(i){
                EditorInfo.IME_ACTION_SEARCH->{

                    location_keyword= et_search_main.text.toString()
                    getLocationList()
                    hideKeyboard()

                    true
                }

            }
            false
        }



        btn_back_join_location_search.setOnClickListener {
            val intent = Intent(applicationContext, MapActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }

//        locationSearchItems = ArrayList()
//        locationSearchItems.add(LocationSearchItem("마포구 상수동 72-1", "와우산로 94"))
//
//        locationSearchAdapter = LocationSearchAdapter(locationSearchItems)
//        rv_result_consumer_location_search.layoutManager = LinearLayoutManager(this)
//        rv_result_consumer_location_search.adapter = locationSearchAdapter
    }
    fun getLocationList(){

        var getLocationList = networkService.getLocationList(header,location_keyword)
        getLocationList.enqueue(object :Callback<GetLocationListResponse>{
            override fun onFailure(call: Call<GetLocationListResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetLocationListResponse>?, response: Response<GetLocationListResponse>?) {
                if(response!!.isSuccessful){
                    locationSearchItems = response.body().documents
                    locationSearchAdapter = LocationSearchAdapter(locationSearchItems)

                    rv_result_consumer_location_search.adapter = locationSearchAdapter

                }
            }

        })
    }

    fun hideKeyboard()
    {
        imm.hideSoftInputFromWindow(et_search_main.getWindowToken(), 0);
    }


}
