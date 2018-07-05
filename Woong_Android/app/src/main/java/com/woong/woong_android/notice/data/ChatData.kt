package com.woong.woong_android.notice.data

data class ChatData(
        var chat_flag : Int,//1은 소비자, 0은 판매자
        var msg : String?

)