package com.woong.woong_android.myproduct.cart

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.myproduct.adapter.MyProductCartAdapter
import com.woong.woong_android.myproduct.get.GetCartResponse
import com.woong.woong_android.myproduct.get.GetCartResponseData
import com.woong.woong_android.myproduct.payment.PaymentActivity
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_myproduct_bookmark.view.*
import kotlinx.android.synthetic.main.fragment_myproduct_cart.view.*
import kotlinx.android.synthetic.main.item_cart_myproduct.view.*
import retrofit2.Call
import retrofit2.Response

class MyProductCart : Fragment() {

    lateinit var myProductCartAdapter: MyProductCartAdapter
    lateinit var cartItems : ArrayList<GetCartResponseData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_myproduct_cart,container,false)

        cartItems = ArrayList()

        var networkService: NetworkService = ApplicationController.instance.networkService
        var requestManager: RequestManager = Glide.with(this)

        val getFavoriteItem = networkService.getCart(woong_usertoken.user_token)
        getFavoriteItem.enqueue(object: retrofit2.Callback<GetCartResponse>{
            override fun onFailure(call: Call<GetCartResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetCartResponse>?, response: Response<GetCartResponse>?) {
                if(response!!.isSuccessful){
                    cartItems = response.body().data
                    myProductCartAdapter = MyProductCartAdapter(cartItems, requestManager)
                    v.rv_cart_myproduct.layoutManager = LinearLayoutManager(context)
                    v.rv_cart_myproduct.adapter = myProductCartAdapter
                }
            }
        })
        //수량같은경우 조절할수있어야 하고 소계는 안드에서 계산처리

        v.all_checkbox_header_myproduct.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                for(i in 0 until v.rv_cart_myproduct.childCount){
                        var cb : CheckBox = v.rv_cart_myproduct.getChildAt(i).checkbox_cart_myproduct
                        cb.isChecked = true
                    }

            }else{
                for(i in 0 until v.rv_cart_myproduct.childCount){
                        var cb : CheckBox = v.rv_cart_myproduct.getChildAt(i).checkbox_cart_myproduct
                        cb.isChecked = false
                    }
            }
        }
        v.btn_order_myproduct.setOnClickListener {
            val intent = Intent(context,PaymentActivity::class.java)
            startActivity(intent)
        }
        return v
    }
}