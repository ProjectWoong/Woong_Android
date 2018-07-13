package com.woong.woong_android.myproduct.viewholder

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.item_cart_myproduct.*
import org.w3c.dom.Text

class MyProductCartViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var productimg :ImageView = itemView!!.findViewById(R.id.productimg_cart_myproduct) as ImageView
    var marketname :TextView= itemView!!.findViewById(R.id.marketname_cart_myproduct) as TextView
    var cost :TextView = itemView!!.findViewById(R.id.cost_cart_myproduct) as TextView
    var delivery :TextView = itemView!!.findViewById(R.id.tv_deliver_cart) as TextView
    var checkbox :CheckBox= itemView!!.findViewById(R.id.checkbox_cart_myproduct) as CheckBox
    var del :TextView = itemView!!.findViewById(R.id.btn_cancle_myproduct) as TextView
    var plusbtn :ImageView = itemView!!.findViewById(R.id.iv_plus_product) as ImageView
    var minusbtn :ImageView = itemView!!.findViewById(R.id.iv_minus_product) as ImageView
    var quantity :TextView = itemView!!.findViewById(R.id.quantity_cart_product) as TextView
    var subtotal :TextView = itemView!!.findViewById(R.id.subtotal_cart_myproduct) as TextView

}