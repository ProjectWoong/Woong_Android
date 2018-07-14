package com.woong.woong_android.notice.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.chat
import com.woong.woong_android.notice.get.GetChatRoomResponseData
import com.woong.woong_android.notice.message.chat.NoticeChatActivity
import com.woong.woong_android.notice.viewholder.NtMessageViewHolder

class NtMessageAdapter(private var messageItems : ArrayList<GetChatRoomResponseData>,var requestManager: RequestManager,var context: Context) : RecyclerView.Adapter<NtMessageViewHolder>() {

//    private  lateinit var onItemClick : View.OnClickListener
//    fun setOnItemClickListener(I : View.OnClickListener){
//        onItemClick = I
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NtMessageViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_message_notice,parent,false)
        //mainView.setOnClickListener(onItemClick)
        return NtMessageViewHolder(mainView)
    }

    override fun getItemCount(): Int = messageItems.size

    override fun onBindViewHolder(holder: NtMessageViewHolder, position: Int) {
        if (messageItems[position].unread_count > 0){ //새 메세지 도착
            holder.alarm.text = messageItems[position].unread_count.toString()
            holder.title.setBackgroundColor(Color.parseColor("#237A59"))
            holder.title.text = messageItems[position].market_name
            holder.recentmsg.text = messageItems[position].recent_message
            requestManager.load(messageItems[position].farmer_image).into(holder.img)
            holder.time.text = messageItems[position].interval_time

            holder.bgr.setOnClickListener {
                chat.chat_room_num = messageItems[position].chatting_room_id
                chat.market_user_id = messageItems[position].market_id
                chat.room_user_id = messageItems[position].room_user_id
                val intent : Intent = Intent(context, NoticeChatActivity::class.java)
                context.startActivity(intent)

            }

        }else if(messageItems[position].unread_count == 0) { //읽었던 메세지
            holder.alarm.text = messageItems[position].unread_count.toString()
            holder.alarm.visibility = View.INVISIBLE
            holder.title.text = messageItems[position].market_name
            holder.recentmsg.text = messageItems[position].recent_message
            requestManager.load(messageItems[position].farmer_image).into(holder.img)
            holder.time.text = messageItems[position].interval_time

            holder.bgr.setOnClickListener {
                chat.chat_room_num = messageItems[position].chatting_room_id
                val intent : Intent = Intent(context, NoticeChatActivity::class.java)
                context.startActivity(intent)

            }

        }

    }


}