package com.woong.woong_android.myproduct.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.woong.woong_android.R

class MyProductPaymentViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var name : TextView = itemView!!.findViewById(R.id.name_mknpd_payment) as TextView
}