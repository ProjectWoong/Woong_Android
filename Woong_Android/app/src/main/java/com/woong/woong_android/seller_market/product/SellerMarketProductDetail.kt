package com.woong.woong_android.seller_market.product

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.myproduct.post.PostCartResponse
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.get.GetProductDetailResponse
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_sellermarket_productdetail.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellerMarketProductDetail : Fragment() {
    lateinit var networkService: NetworkService
    lateinit var requestManager: RequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sellermarket_productdetail,container,false)
        networkService = ApplicationController.instance.networkService
        var market_id = arguments!!.getInt("market_id")
        var item_id = arguments!!.getInt("item_id")
        Log.v("넘겨들",item_id.toString())

        requestManager = Glide.with(this)
        v.btn_cart_productdetail.setOnClickListener {
            val postCart = networkService.postCart(woong_usertoken.user_token, item_id)
            postCart.enqueue(object:Callback<PostCartResponse>{
                override fun onFailure(call: Call<PostCartResponse>?, t: Throwable?) {
                }

                override fun onResponse(call: Call<PostCartResponse>?, response: Response<PostCartResponse>?) {
                    Toast.makeText(it.context, "상품을 장바구니에 담았습니다.", Toast.LENGTH_SHORT).show()
                }
            })
        }
        var getProductDetil = networkService.getProductDetail(market_id,item_id)
        getProductDetil.enqueue(object : Callback<GetProductDetailResponse>{
            override fun onFailure(call: Call<GetProductDetailResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetProductDetailResponse>?, response: Response<GetProductDetailResponse>?) {
                if(response!!.isSuccessful){
                    requestManager.load(response.body().data.file_key).into(v.iv_product_productdetail)
                    v.name_item_productdetail.text = response.body().data.item_name
                    v.info_item_productdetail.text = response.body().data.item_info
                    v.cook_item_productdetail.text = response.body().data.item_cook
                    v.maintain_item_productdetail.text = response.body().data.item_maintain
                    v.weight_item_productdetail.text = response.body().data.packaging
                    v.manufacture_item_productdetail.text = response.body().data.item_manufacture
                    v.expiration_item_productdetail.text = response.body().data.item_expiration
                    v.related_item_productdetail.text = response.body().data.item_related
                    v.producer_item_productdetail.text = response.body().data.item_producer
                }
            }
        })
        return v
    }
}