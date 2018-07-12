package com.woong.woong_android.seller_market.intro

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.get.GetMarketInfoResponse
import kotlinx.android.synthetic.main.fragment_sellermarket_intro.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellerMarketIntro: Fragment() {
    lateinit var networkService: NetworkService
    lateinit var requestManager: RequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_sellermarket_intro,container,false)
        requestManager = Glide.with(this)
        networkService = ApplicationController.instance.networkService

        //유저토큰(header) 마켓아이디(path)
        var getMarketIntro = networkService.getMarketDetail("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxLCJlbWFpbCI6ImRvbmdzdUBnbWFpbC5jb20iLCJpYXQiOjE1MzEyMjc1NjUsImV4cCI6ODc5MzEyMjc1NjUsImlzcyI6InNlcnZpY2UiLCJzdWIiOiJ1c2VyX3Rva2VuIn0.pNHa45rQvyXEEb0PxAwUZhnQpof17GLDmVjBrQxGySo",1)
        getMarketIntro.enqueue(object :Callback<GetMarketInfoResponse>{
            override fun onFailure(call: Call<GetMarketInfoResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetMarketInfoResponse>?, response: Response<GetMarketInfoResponse>?) {
                if(response!!.isSuccessful){
                    var str:List<String> =response.body().data[0].tag_name!!.split(",")
                    tv_tag1_intro.text="#"+str[0]
                    tv_tag2_intro.text="#"+str[1]
                    //tv_tag3_intro.text="#"+str[2]

                    tv_hi_intro.text=response.body().data[0].market_info

                    requestManager.load(response.body().data[0].title_image_key).into(iv_representimg_sellermarket_intro)


                }
            }

        })

        return v
    }


}