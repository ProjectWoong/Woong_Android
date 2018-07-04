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
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.adapter.MyProductCartAdapter
import com.woong.woong_android.myproduct.data.MyProductCartData
import com.woong.woong_android.myproduct.payment.PaymentActivity
import kotlinx.android.synthetic.main.fragment_myproduct_bookmark.view.*
import kotlinx.android.synthetic.main.fragment_myproduct_cart.*
import kotlinx.android.synthetic.main.fragment_myproduct_cart.view.*
import kotlinx.android.synthetic.main.item_cart_myproduct.view.*

class MyProductCart : Fragment() {

    lateinit var myProductCartAdapter: MyProductCartAdapter
    lateinit var cartItems : ArrayList<MyProductCartData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_myproduct_cart,container,false)

        cartItems = ArrayList()

        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500"))
        //수량같은경우 조절할수있어야 하고 소계는 안드에서 계산처리
        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500"))
        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500"))
        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500"))
        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500"))
        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500"))
        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500"))
        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500"))

        myProductCartAdapter = MyProductCartAdapter(cartItems)

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


        v.rv_cart_myproduct.layoutManager = LinearLayoutManager(context)
        v.rv_cart_myproduct.adapter = myProductCartAdapter


        return v
    }
}