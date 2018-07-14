package com.woong.woong_android.notice.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R
import org.w3c.dom.Text

class NtDeliverandReviewViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var deliver_num : TextView= itemView!!.findViewById(R.id.delivernum_deliver_notice) as TextView
    var img : ImageView = itemView!!.findViewById(R.id.profileimg_message_notice) as ImageView
    var market_name :TextView = itemView!!.findViewById(R.id.marketname_alarm_item) as TextView
    var product_name : TextView = itemView!!.findViewById(R.id.productname_alarm_item) as TextView
    var order_date : TextView = itemView!!.findViewById(R.id.date_order_alarm_item) as TextView
    var order_cost : TextView = itemView!!.findViewById(R.id.cost_order_alarm_item) as TextView
    var review_write_btn : Button = itemView!!.findViewById(R.id.writebtn_review_message) as Button
}