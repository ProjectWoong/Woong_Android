package com.woong.woong_android.myproduct.cart

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.adapter.MyProductCartAdapter
import com.woong.woong_android.myproduct.data.MyProductCartData
import kotlinx.android.synthetic.main.fragment_myproduct_bookmark.view.*
import kotlinx.android.synthetic.main.fragment_myproduct_cart.*
import kotlinx.android.synthetic.main.fragment_myproduct_cart.view.*

class MyProductCart : Fragment() {

    lateinit var myProductCartAdapter: MyProductCartAdapter
    lateinit var cartItems : ArrayList<MyProductCartData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_myproduct_cart,container,false)


        cartItems = ArrayList()


//        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500",true))
//        //수량같은경우 조절할수있어야 하고 소계는 안드에서 계산처리
//        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500",true))
//        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500",true))
//        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500",true))
//        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500",true))
//        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500",true))
//        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500",true))
//        cartItems.add(MyProductCartData(R.drawable.ic_launcher_background,"토종흙감자","곤쥬마켓","1","kg","6500","3","15500",true))

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


        v.rv_cart_mymarket.layoutManager = LinearLayoutManager(context)
        v.rv_cart_mymarket.adapter = myProductCartAdapter


        return v
    }
}