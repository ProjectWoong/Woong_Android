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
import com.woong.woong_android.register_review

class NtDelivertandReviewAdapter(var context: Context,private var deliveryItems : ArrayList<DeliveryData>) :RecyclerView.Adapter<NtDeliverandReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NtDeliverandReviewViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_delinreview_notice,parent,false)
        return NtDeliverandReviewViewHolder(mainView)
    }

    override fun getItemCount(): Int = deliveryItems.size

    override fun onBindViewHolder(holder: NtDeliverandReviewViewHolder, position: Int) {
        if(deliveryItems[position].isShipping == 1){//1이면 배송중
            holder.img.setImageResource(deliveryItems[position].product_img)
            holder.market_name.text = deliveryItems[position].market_name
            holder.order_date.text = deliveryItems[position].order_date
            holder.order_cost.text = deliveryItems[position].order_cost
            holder.deliver_num.visibility = View.VISIBLE
            holder.review_write_btn.visibility = View.INVISIBLE
        }else if(deliveryItems[position].isShipping == 0){ //배송완료
            holder.deliver_num.visibility = View.INVISIBLE
            holder.img.setImageResource(deliveryItems[position].product_img)
            holder.market_name.text = deliveryItems[position].market_name
            holder.order_date.text = deliveryItems[position].order_date
            holder.order_cost.text = deliveryItems[position].order_cost
            holder.review_write_btn.visibility = View.VISIBLE
            holder.review_write_btn.setOnClickListener {
                if(deliveryItems[position].market_id==1){
                    register_review.market_id = 1
                    register_review.product_img = deliveryItems[position].product_img
                    register_review.market_name = deliveryItems[position].market_name.toString()
                    register_review.product_name = deliveryItems[position].product_name.toString()
                }else if(deliveryItems[position].market_id==2){
                    register_review.market_id = 2
                    register_review.product_img = deliveryItems[position].product_img
                    register_review.market_name = deliveryItems[position].market_name.toString()
                    register_review.product_name = deliveryItems[position].product_name.toString()

                }else if(deliveryItems[position].market_id==3){
                    register_review.market_id = 3
                    register_review.product_img = deliveryItems[position].product_img
                    register_review.market_name = deliveryItems[position].market_name.toString()
                    register_review.product_name = deliveryItems[position].product_name.toString()
                }else if(deliveryItems[position].market_id==4){
                    register_review.market_id = 4
                    register_review.product_img = deliveryItems[position].product_img
                    register_review.market_name = deliveryItems[position].market_name.toString()
                    register_review.product_name = deliveryItems[position].product_name.toString()
                }else if(deliveryItems[position].market_id==5){
                    register_review.market_id = 5
                    register_review.product_img = deliveryItems[position].product_img
                    register_review.market_name = deliveryItems[position].market_name.toString()
                    register_review.product_name = deliveryItems[position].product_name.toString()
                }else if(deliveryItems[position].market_id==6){
                    register_review.market_id = 6
                    register_review.product_img = deliveryItems[position].product_img
                    register_review.market_name = deliveryItems[position].market_name.toString()
                    register_review.product_name = deliveryItems[position].product_name.toString()
                }
                var intent : Intent = Intent(context,ReviewWriteActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}