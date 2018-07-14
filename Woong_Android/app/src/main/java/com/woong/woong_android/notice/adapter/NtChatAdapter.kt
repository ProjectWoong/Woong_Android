package com.woong.woong_android.notice.adapter

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import com.woong.woong_android.R
import com.woong.woong_android.notice.get.ChatMessageListData
import com.woong.woong_android.notice.viewholder.NtChatViewHolder

class NtChatAdapter(private var chatItems : ArrayList<ChatMessageListData>) : RecyclerView.Adapter<NtChatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NtChatViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_notice,parent,false)

        return NtChatViewHolder(v)
    }

    override fun getItemCount(): Int =chatItems.size

    override fun onBindViewHolder(holder: NtChatViewHolder, position: Int) {
        if(chatItems[position].send_user_id != 0){ //판매자
            holder.msg.text = chatItems[position].content
            holder.time.text = chatItems[position].date
            val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
            holder.msg.layoutParams=params
            val paramsq = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
            paramsq.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
            holder.time.layoutParams=paramsq
            holder.time.setPadding(20,20,20,20)

            holder.msg.gravity =Gravity.RIGHT
            holder.msg.setBackgroundResource(R.drawable.chat_background_gray)


        }else if(chatItems[position].send_user_id== 0){ //소비자
            holder.msg.text = chatItems[position].content
         //   holder.msg.gravity = Gravity.RIGHT
            holder.time.text = chatItems[position].date
            holder.msg.setBackgroundResource(R.drawable.chat_background_green)
           // holder.seller_icon.visibility = View.INVISIBLE
        }

    }
}