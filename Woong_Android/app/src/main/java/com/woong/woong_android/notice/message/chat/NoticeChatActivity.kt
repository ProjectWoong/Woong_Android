package com.woong.woong_android.notice.message.chat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.chat
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.notice.adapter.NtChatAdapter
import com.woong.woong_android.notice.get.ChatMessageListData
import com.woong.woong_android.notice.get.GetChatMessageResponse
import com.woong.woong_android.notice.post.PostChatMessageResponse
import com.woong.woong_android.notice.post.PostChatMessageResponseData
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.activity_notice_chat.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeChatActivity : AppCompatActivity() {

    lateinit var chatItems : ArrayList<ChatMessageListData>
    lateinit var ntChatAdapter: NtChatAdapter
    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_chat)

        networkService = ApplicationController.instance.networkService
        val usertoken = woong_usertoken.user_token
        val chat_room_id = chat.chat_room_num
        if(chat.new_room_flag == 1){

            val getChatMessage = networkService.getChatMessage(usertoken,chat_room_id)

            getChatMessage.enqueue(object :Callback<GetChatMessageResponse>{
                override fun onFailure(call: Call<GetChatMessageResponse>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<GetChatMessageResponse>?, response: Response<GetChatMessageResponse>?) {
                    if(response!!.isSuccessful){
                        chatItems = response.body().data.send_data
                        ntChatAdapter = NtChatAdapter(chatItems)
                        rv_chat_notice.layoutManager = LinearLayoutManager(this@NoticeChatActivity)
                        rv_chat_notice.adapter = ntChatAdapter
                        rv_chat_notice.scrollToPosition(ntChatAdapter.itemCount - 1)
                    }
                }

            })

            btn_send_notice.setOnClickListener {

                val postChatMessageListData = PostChatMessageResponseData(chat.room_user_id,chat.market_user_id,input_message_notice.text.toString())
                val postChatMessage = networkService.postChatMessage(usertoken,postChatMessageListData)
                postChatMessage.enqueue(object : Callback<PostChatMessageResponse>{
                    override fun onFailure(call: Call<PostChatMessageResponse>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<PostChatMessageResponse>?, response: Response<PostChatMessageResponse>?) {

                        if(response!!.isSuccessful){
                            Toast.makeText(applicationContext,"dfsfd",Toast.LENGTH_SHORT).show()

//                        ntChatAdapter = NtChatAdapter(chatItems)
//                        rv_chat_notice.layoutManager = LinearLayoutManager(this@NoticeChatActivity)
//                        rv_chat_notice.adapter = ntChatAdapter
//                        rv_chat_notice.scrollToPosition(ntChatAdapter.itemCount - 1)
//                        val set = ""
//                        input_message_notice.setText("")

                            chatItems.add(ChatMessageListData(0,input_message_notice.text.toString(),""))//date
                            val getChatMessage = networkService.getChatMessage(usertoken,chat_room_id)

                            getChatMessage.enqueue(object :Callback<GetChatMessageResponse>{
                                override fun onFailure(call: Call<GetChatMessageResponse>?, t: Throwable?) {

                                }

                                override fun onResponse(call: Call<GetChatMessageResponse>?, response: Response<GetChatMessageResponse>?) {
                                    if(response!!.isSuccessful){
                                        chatItems = response.body().data.send_data
                                        ntChatAdapter = NtChatAdapter(chatItems)
                                        rv_chat_notice.layoutManager = LinearLayoutManager(this@NoticeChatActivity)
                                        rv_chat_notice.adapter = ntChatAdapter
                                        rv_chat_notice.scrollToPosition(ntChatAdapter.itemCount - 1)
                                    }
                                }

                            })
                        }
                    }

                })

            }
            chat.new_room_flag = 0;
        }else {
            val getChatMessage = networkService.getChatMessage(usertoken,chat_room_id)

            getChatMessage.enqueue(object :Callback<GetChatMessageResponse>{
                override fun onFailure(call: Call<GetChatMessageResponse>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<GetChatMessageResponse>?, response: Response<GetChatMessageResponse>?) {
                    if(response!!.isSuccessful){
                        chatItems = response.body().data.send_data
                        ntChatAdapter = NtChatAdapter(chatItems)
                        rv_chat_notice.layoutManager = LinearLayoutManager(this@NoticeChatActivity)
                        rv_chat_notice.adapter = ntChatAdapter
                        rv_chat_notice.scrollToPosition(ntChatAdapter.itemCount - 1)
                    }
                }

            })

            btn_send_notice.setOnClickListener {

                val postChatMessageListData = PostChatMessageResponseData(chat.room_user_id,chat.market_user_id,input_message_notice.text.toString())
                val postChatMessage = networkService.postChatMessage(usertoken,postChatMessageListData)
                postChatMessage.enqueue(object : Callback<PostChatMessageResponse>{
                    override fun onFailure(call: Call<PostChatMessageResponse>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<PostChatMessageResponse>?, response: Response<PostChatMessageResponse>?) {

                        if(response!!.isSuccessful){
                            Toast.makeText(applicationContext,"dfsfd",Toast.LENGTH_SHORT).show()

//                        ntChatAdapter = NtChatAdapter(chatItems)
//                        rv_chat_notice.layoutManager = LinearLayoutManager(this@NoticeChatActivity)
//                        rv_chat_notice.adapter = ntChatAdapter
//                        rv_chat_notice.scrollToPosition(ntChatAdapter.itemCount - 1)
//                        val set = ""
//                        input_message_notice.setText("")

                            chatItems.add(ChatMessageListData(0,input_message_notice.text.toString(),""))//date
                            val getChatMessage = networkService.getChatMessage(usertoken,chat_room_id)

                            getChatMessage.enqueue(object :Callback<GetChatMessageResponse>{
                                override fun onFailure(call: Call<GetChatMessageResponse>?, t: Throwable?) {

                                }

                                override fun onResponse(call: Call<GetChatMessageResponse>?, response: Response<GetChatMessageResponse>?) {
                                    if(response!!.isSuccessful){
                                        chatItems = response.body().data.send_data
                                        ntChatAdapter = NtChatAdapter(chatItems)
                                        rv_chat_notice.layoutManager = LinearLayoutManager(this@NoticeChatActivity)
                                        rv_chat_notice.adapter = ntChatAdapter
                                        rv_chat_notice.scrollToPosition(ntChatAdapter.itemCount - 1)
                                    }
                                }

                            })
                        }
                    }

                })

            }

        }





    }
}