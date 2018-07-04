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
//    var headerflags = headerflag
//    var footerflags = footerflag
//    lateinit var productimg :ImageView
//    lateinit var marketname :TextView
//    lateinit var productname :TextView
//    lateinit var unitnum :TextView
//    lateinit var unitname :TextView
//    lateinit var cost :TextView
//    lateinit var quantity :TextView
//    lateinit var subtotal :TextView
//    lateinit var checkbox : CheckBox
//
//    lateinit var footer_totalproduct : TextView
//    lateinit var footer_totalnum : TextView
//
//    lateinit var header_checkbox : CheckBox



            var productimg : ImageView = itemView!!.findViewById(R.id.productimg_cart_myproduct) as ImageView
            var marketname : TextView= itemView!!.findViewById(R.id.marketname_cart_myproduct) as TextView
            var productname :TextView = itemView!!.findViewById(R.id.productname_cart_myproduct) as TextView
            var unitnum :TextView = itemView!!.findViewById(R.id.unitnum_cart_myproduct) as TextView
            var unitname :TextView= itemView!!.findViewById(R.id.unitname_cart_myproduct) as TextView
            var cost:TextView = itemView!!.findViewById(R.id.cost_cart_myproduct) as TextView
            var quantity :TextView= itemView!!.findViewById(R.id.quantity_cart_product) as TextView
            var subtotal :TextView = itemView!!.findViewById(R.id.subtotal_cart_myproduct) as TextView
            var checkbox :CheckBox= itemView!!.findViewById(R.id.checkbox_cart_myproduct) as CheckBox

            //var footer_totalproduct :TextView = itemView!!.findViewById(R.id.pdtotalnum_footer_myproduct) as TextView
            //var footer_totalnum :TextView = itemView!!.findViewById(R.id.totalnum_footer_myproduct) as TextView


            //var header_checkbox :CheckBox = itemView!!.findViewById(R.id.all_checkbox_header_myproduct) as CheckBox




}