package com.woong.woong_android.notice.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.notice.data.DeliveryData
import com.woong.woong_android.notice.deliveryandreview.review_write.ReviewWriteActivity
import com.woong.woong_android.notice.viewholder.NtDeliverandReviewViewHolder

class NtDelivertandReviewAdapter(var context: Context,private var deliveryItems : ArrayList<DeliveryData>) :RecyclerView.Adapter<NtDeliverandReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NtDeliverandReviewViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_delinreview_notice,parent,false)
        return NtDeliverandReviewViewHolder(mainView)
    }

    override fun getItemCount(): Int = deliveryItems.size

    override fun onBindViewHolder(holder: NtDeliverandReviewViewHolder, position: Int) {
        if(deliveryItems[position].isShipping == 1){//1이면 배송중
            holder.deliver_num.visibility = View.VISIBLE
            holder.review_write_btn.visibility = View.INVISIBLE
        }else if(deliveryItems[position].isShipping == 0){ //배송완료
            holder.deliver_num.visibility = View.INVISIBLE
            holder.review_write_btn.visibility = View.VISIBLE
            holder.review_write_btn.setOnClickListener {
                var intent : Intent = Intent(context,ReviewWriteActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}