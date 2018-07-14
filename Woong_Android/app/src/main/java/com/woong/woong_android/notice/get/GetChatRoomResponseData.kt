package com.woong.woong_android.notice.get

data class GetChatRoomResponseData (

        var farmer_image : String?,
        var market_name : String?,
        var chatting_room_id : Int,
        var market_id : Int,
        var unread_count : Int,
        var recent_message : String?,
        var interval_time : String?,
        var room_user_id:Int

)