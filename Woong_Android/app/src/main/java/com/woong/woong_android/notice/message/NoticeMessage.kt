package com.woong.woong_android.notice.message

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.notice.adapter.NtMessageAdapter
import com.woong.woong_android.notice.get.GetChatRoomResponse
import com.woong.woong_android.notice.get.GetChatRoomResponseData
import com.woong.woong_android.notice.message.chat.NoticeChatActivity
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_notice_message.*
import kotlinx.android.synthetic.main.fragment_notice_message.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeMessage :Fragment() {


    lateinit var messageItems : ArrayList<GetChatRoomResponseData>
    lateinit var ntMessageAdapter: NtMessageAdapter
    lateinit var requestManager : RequestManager
    lateinit var networkService: NetworkService

    lateinit var newItems : ArrayList<GetChatRoomResponseData>
    lateinit var oldItems : ArrayList<GetChatRoomResponseData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_notice_message,container,false)

        var  user_token = woong_usertoken.user_token

        requestManager = Glide.with(this)
        networkService = ApplicationController.instance.networkService

        val getChatRoom = networkService.getChatRoom(user_token)
        getChatRoom.enqueue(object:Callback<GetChatRoomResponse>{
            override fun onFailure(call: Call<GetChatRoomResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetChatRoomResponse>?, response: Response<GetChatRoomResponse>?) {

                if(response!!.isSuccessful){
                    messageItems = response.body().data
                    newItems = ArrayList()
                    oldItems = ArrayList()

                    for(i in 0 until messageItems.size){
                        if(messageItems[i].unread_count >0){ //new message data
                            var new = messageItems[i].unread_count
                            var title = messageItems[i].market_name
                            var time = messageItems[i].interval_time
                            var img = messageItems[i].farmer_image
                            var recentmsg = messageItems[i].recent_message
                            var chatroom_id = messageItems[i].chatting_room_id
                            var market_id = messageItems[i].market_id
                            var room_user_id = messageItems[i].room_user_id
                            newItems.add(GetChatRoomResponseData(img,title,chatroom_id,market_id,new,recentmsg,time,room_user_id))
                        }
                    }
                    for(i in 0 until messageItems.size){
                        if(messageItems[i].unread_count ==0){ //old message data

                            var old = messageItems[i].unread_count
                            var title = messageItems[i].market_name
                            var time = messageItems[i].interval_time
                            var img = messageItems[i].farmer_image
                            var recentmsg = messageItems[i].recent_message
                            var chatroom_id = messageItems[i].chatting_room_id
                            var market_id = messageItems[i].market_id
                            var room_user_id = messageItems[i].room_user_id
                            oldItems.add(GetChatRoomResponseData(img,title,chatroom_id,market_id,old,recentmsg,time,room_user_id))
                        }
                    }
                    ntMessageAdapter = NtMessageAdapter(newItems,requestManager,context!!)

                   // ntMessageAdapter.setOnItemClickListener(this@NoticeMessage)
                    v.rv_new_message.layoutManager = LinearLayoutManager(context)
                    v.rv_new_message.adapter = ntMessageAdapter


                    ntMessageAdapter = NtMessageAdapter(oldItems,requestManager,context!!)
                   // ntMessageAdapter.setOnItemClickListener(this@NoticeMessage)
                    v.rv_old_message.layoutManager = LinearLayoutManager(context)
                    v.rv_old_message.adapter = ntMessageAdapter


                }
            }

        })


        return v
    }
}