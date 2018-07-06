package com.woong.woong_android.notice.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R

class NtDeliverandReviewViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var deliver_num : TextView= itemView!!.findViewById(R.id.delivernum_deliver_notice) as TextView
    var review_write_btn : ImageView = itemView!!.findViewById(R.id.writebtn_review_message) as ImageView
}