package com.woong.woong_android.map.location_register

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.woong.woong_android.R
import com.woong.woong_android.map.get.GetLocationListResponse
import com.woong.woong_android.map.get.GetLocationListResponseData
import com.woong.woong_android.network.NetworkService
import kotlinx.android.synthetic.main.activity_location_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationSearchActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        val idx : Int = rv_result_consumer_location_search.getChildAdapterPosition(p0)
        val intent = Intent(applicationContext,com.woong.woong_android.map.MapActivity::class.java)
        intent.putExtra("search_address",locationSearchItems[idx].address_name)
        intent.putExtra("real_address_x",locationSearchItems[idx].x)
        intent.putExtra("real_address_y",locationSearchItems[idx].y)
        intent.putExtra("flag",1)
        startActivity(intent)
        finish()

    }

    lateinit var imm: InputMethodManager
    lateinit var networkService: NetworkService
    lateinit var locationSearchItems : ArrayList<GetLocationListResponseData>
    lateinit var locationSearchAdapter: LocationSearchAdapter

    var location_keyword=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_search)
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager //키보드 내리기위해서

       et_search_main.setOnEditorActionListener { textView, i, keyEvent ->
            when(i){
                EditorInfo.IME_ACTION_SEARCH->{
                    location_keyword=  et_search_main.text.toString()
                    getLocationList()
                    hideKeyboard()
                    true
                }

            }
            false
        }


    }
    fun getLocationList(){
        val builder = Retrofit.Builder()
        val retrofit_loc_search = builder
                .baseUrl("https://dapi.kakao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        networkService = retrofit_loc_search.create(NetworkService::class.java)

        var header = "KakaoAK 865f5a39675526bdbdd0855cbc560e9b"


        rv_result_consumer_location_search.layoutManager = LinearLayoutManager(this)

        var getLocationList = networkService.getLocationList(header,location_keyword)
        getLocationList.enqueue(object : Callback<GetLocationListResponse> {
            override fun onFailure(call: Call<GetLocationListResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetLocationListResponse>?, response: Response<GetLocationListResponse>?) {
                if(response!!.isSuccessful){
                    locationSearchItems = response.body().documents
                    locationSearchAdapter = LocationSearchAdapter(locationSearchItems)

                    rv_result_consumer_location_search.adapter = locationSearchAdapter
                    locationSearchAdapter.setOnItemClickListener(this@LocationSearchActivity)

                }
            }

        })
    }

    fun hideKeyboard()
    {
        imm.hideSoftInputFromWindow( et_search_main.getWindowToken(), 0);
    }
}
