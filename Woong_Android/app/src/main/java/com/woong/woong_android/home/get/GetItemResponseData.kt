package com.woong.woong_android.home.get

data class GetItemResponseData (
        var item_id:Int,
        var market_id:Int,
        var main_id:Int,
        var sub_id:Int,
        var item_name: String?,
        var market_name: String?,
        var item_unit: String?,
        var item_price: Int,
        var quick: Int,
        var delivery: Int,
        var file_key: String?,
        var favorite_flag: Int
)