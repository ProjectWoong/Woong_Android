package com.woong.woong_android.seller_market.review

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.seller_market.adapter.SellerMarketReviewAdapter
import com.woong.woong_android.seller_market.review.data.SellerMarketReviewData
import kotlinx.android.synthetic.main.fragment_sellermarket_review.*
import kotlinx.android.synthetic.main.fragment_sellermarket_review.view.*
import kotlinx.android.synthetic.main.item_sellermarket_review.*

class SellerMarketReview: Fragment() {
    lateinit var sellerMarketReviewAdapter : SellerMarketReviewAdapter
    lateinit var reviewItems : ArrayList<SellerMarketReviewData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sellermarket_review,container,false)
        reviewItems = ArrayList()

        reviewItems.add(SellerMarketReviewData("뚜똥이","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("형듀이","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("고라니","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("뚜냥이","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("띠똥이","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("고라니","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("뚜냥이","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("띠똥이","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("고라니","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("뚜냥이","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))
        reviewItems.add(SellerMarketReviewData("띠똥이","으아ㅓㅏ러알날ㅇ라깅날ㄴ략"))

        v.btn_show_more_review.setOnClickListener {
            sellerMarketReviewAdapter = SellerMarketReviewAdapter(reviewItems,1)
            v.rv_sellermarket_review.layoutManager = LinearLayoutManager(context)
            v.rv_sellermarket_review.adapter = sellerMarketReviewAdapter
        }

        sellerMarketReviewAdapter = SellerMarketReviewAdapter(reviewItems,0)
        v.rv_sellermarket_review.layoutManager = LinearLayoutManager(context)
        v.rv_sellermarket_review.adapter = sellerMarketReviewAdapter


        return v
    }
}