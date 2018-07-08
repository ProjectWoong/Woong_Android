package com.woong.woong_android.map.location_change

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.map.get.GetLocationListResponse
import com.woong.woong_android.map.get.GetLocationListResponseData
import com.woong.woong_android.map.location_register.LocationSearchAdapter
import com.woong.woong_android.network.NetworkService
import kotlinx.android.synthetic.main.fragment_locationsearch_result.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationSearchResult() : android.support.v4.app.Fragment() {

    lateinit var networkService :NetworkService
    lateinit var locationSearchItems : ArrayList<GetLocationListResponseData>
    lateinit var locationSearchAdapter : LocationSearchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_locationsearch_result,container,false)

        val builder = Retrofit.Builder()
        val retrofit_loc_search = builder
                .baseUrl("https://dapi.kakao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        networkService = retrofit_loc_search.create(NetworkService::class.java)

        var header = "KakaoAK 865f5a39675526bdbdd0855cbc560e9b"
        var location_keyword :String = arguments!!.getString("keyword")

        view.rv_result_consumer_location_search.layoutManager = LinearLayoutManager(context)

        var getLocationList = networkService.getLocationList(header,location_keyword)
        getLocationList.enqueue(object : Callback<GetLocationListResponse> {
            override fun onFailure(call: Call<GetLocationListResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetLocationListResponse>?, response: Response<GetLocationListResponse>?) {
                if(response!!.isSuccessful){
                    locationSearchItems = response.body().documents
                    locationSearchAdapter = LocationSearchAdapter(locationSearchItems)

                    view.rv_result_consumer_location_search.adapter = locationSearchAdapter

                }
            }

        })


        return view

    }

}