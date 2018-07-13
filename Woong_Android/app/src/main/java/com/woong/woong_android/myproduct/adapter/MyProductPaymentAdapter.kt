package com.woong.woong_android.myproduct.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.get.GetCartResponseData
import com.woong.woong_android.myproduct.payment.data.MyProductPaymentData
import com.woong.woong_android.myproduct.viewholder.MyProductPaymentViewHolder

class MyProductPaymentAdapter(private var paymentItems : ArrayList<MyProductPaymentData>) : RecyclerView.Adapter<MyProductPaymentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductPaymentViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_payment_myproduct,parent,false)
        return MyProductPaymentViewHolder(mainView)
    }

    override fun getItemCount(): Int = paymentItems.size

    override fun onBindViewHolder(holder: MyProductPaymentViewHolder, position: Int) {
        holder.name.text = paymentItems[position].name
    }

}