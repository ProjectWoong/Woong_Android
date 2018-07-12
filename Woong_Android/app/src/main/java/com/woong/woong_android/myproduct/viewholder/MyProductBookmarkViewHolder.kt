package com.woong.woong_android.myproduct.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.item_bookmark_myproduct.view.*

class MyProductBookmarkViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var productimg : ImageView = itemView!!.findViewById(R.id.iv_bmproductimg_myproduct) as ImageView
    var marketname : TextView = itemView!!.findViewById(R.id.marketname_bookmark_myproduct) as TextView
    var productname : TextView = itemView!!.findViewById(R.id.productname_bookmark_myproduct) as TextView
    var unitname : TextView = itemView!!.findViewById(R.id.unitname_bookmark_myproduct) as TextView
    var cost : TextView = itemView!!.findViewById(R.id.cost_bookmark_myproduct) as TextView
    var firsttag : TextView = itemView!!.findViewById(R.id.firsttag_bookmark_myproduct) as TextView
    var secondtag : TextView = itemView!!.findViewById(R.id.secondtag_bookmark_myproduct) as TextView
    var favorite : ImageView = itemView!!.findViewById(R.id.btn_bookmark_myproduct) as ImageView
    var cart : ImageView = itemView!!.findViewById(R.id.btn_cart_myproduct) as ImageView
}