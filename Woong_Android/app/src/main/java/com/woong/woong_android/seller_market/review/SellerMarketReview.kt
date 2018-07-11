package com.woong.woong_android.seller_market.review

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.adapter.SellerMarketReviewAdapter
import com.woong.woong_android.seller_market.get.GetMarketReviewResponse
import com.woong.woong_android.seller_market.get.GetMarketReviewResponseData
import kotlinx.android.synthetic.main.fragment_sellermarket_review.*
import kotlinx.android.synthetic.main.fragment_sellermarket_review.view.*
import kotlinx.android.synthetic.main.item_sellermarket_review.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellerMarketReview: Fragment() {
    lateinit var sellerMarketReviewAdapter : SellerMarketReviewAdapter
    lateinit var reviewItems : ArrayList<GetMarketReviewResponseData>
    lateinit var networkService: NetworkService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sellermarket_review,container,false)

        networkService = ApplicationController.instance.networkService

        //market_id (path)
        var getMarketReview = networkService.getMarketReview(1)
        getMarketReview.enqueue(object:Callback<GetMarketReviewResponse>{
            override fun onFailure(call: Call<GetMarketReviewResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetMarketReviewResponse>?, response: Response<GetMarketReviewResponse>?) {
                if(response!!.isSuccessful){
                    var first = response.body().rate.rate_speed
                    var second = response.body().rate.rate_taste
                    var third = response.body().rate.rate_fresh
                    var fourth = response.body().rate.rate_kindness

                    var avr = (first+second+third+fourth)/4

                    v.avr_rating_marketreview.numStars = avr

                    v.first_rating_marketreview.numStars = first
                    v.second_rating_marketreview.numStars = second
                    v.third_rating_marketreview.numStars = third
                    v.fourth_rating_marketreview.numStars = fourth

                    reviewItems = response.body().reviews
                    sellerMarketReviewAdapter = SellerMarketReviewAdapter(reviewItems,0)
                    v.rv_sellermarket_review.layoutManager = LinearLayoutManager(context)
                    v.rv_sellermarket_review.adapter = sellerMarketReviewAdapter


                    v.btn_show_more_review.setOnClickListener {
                        sellerMarketReviewAdapter = SellerMarketReviewAdapter(reviewItems,1)
                        v.rv_sellermarket_review.layoutManager = LinearLayoutManager(context)
                        v.rv_sellermarket_review.adapter = sellerMarketReviewAdapter
                    }





                }
            }

        })






        return v
    }
}