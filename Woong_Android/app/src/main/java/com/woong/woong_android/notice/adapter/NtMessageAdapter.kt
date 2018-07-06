package com.woong.woong_android.notice.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.notice.data.MessageData
import com.woong.woong_android.notice.viewholder.NtMessageViewHolder

class NtMessageAdapter(private var messageItems : ArrayList<MessageData>) : RecyclerView.Adapter<NtMessageViewHolder>() {

    private  lateinit var onItemClick : View.OnClickListener
    fun setOnItemClickListener(I : View.OnClickListener){
        onItemClick = I
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NtMessageViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_message_notice,parent,false)
        mainView.setOnClickListener(onItemClick)
        return NtMessageViewHolder(mainView)
    }

    override fun getItemCount(): Int = messageItems.size

    override fun onBindViewHolder(holder: NtMessageViewHolder, position: Int) {
        if (messageItems[position].alarm > 0){ //새 메세지 도착
            holder.alarm.text = messageItems[position].alarm.toString()
            holder.title.setBackgroundColor(Color.parseColor("#237A59"))

        }else if(messageItems[position].alarm == 0) { //읽었던 메세지
            holder.alarm.text = messageItems[position].alarm.toString()
            holder.alarm.visibility = View.INVISIBLE

        }

    }


}