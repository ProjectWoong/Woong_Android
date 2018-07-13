package com.woong.woong_android.notice.get

data class GetChatRoomResponse (
    var message : String?,
    var data : ArrayList<GetChatRoomResponseData>
)