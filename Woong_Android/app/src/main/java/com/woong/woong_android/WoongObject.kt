package com.woong.woong_android

object woong_usertoken{
    var user_token : String? = ""
    var user_id : String = " "
}
object woong_marketinfo{    // 물품 상세 혹은 마켓에 들어갈 때
    var market_id : Int = 0
    var item_id : Int = 0
}
object TitleName{
    var name : String = ""  // 서브메뉴 이름을 다음 뷰에 넘겨주기 위해
    var main_id : Int = 0   // 메인 메뉴 id
    var sub_id : Int = 0    // 서브 메뉴 id
}
object searchString{
    var flag : Boolean = false
    var str : String = ""
}
object location{
    var logitude : Double = 0.0
    var latitude : Double = 0.0

    var real_address : String = ""
    var simple_address : String = ""
}

object chat{
    var chat_room_num : Int = 0
    var room_user_id :Int = 0
    var market_user_id : Int = 0
}

object previousLocation{
    var history_address = ""
    var longitude : Double = 0.0
    var latitude : Double = 0.0
}

object submain{
    var flag : Int = 0
    var right : Int = 0

}
object frgIntent{
    var flag : Int=0
    var idx : Int=0
}