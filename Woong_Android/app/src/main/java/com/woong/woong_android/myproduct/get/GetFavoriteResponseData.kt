package com.woong.woong_android.myproduct.get

data class GetFavoriteResponseData (
        var item_id: Int,
        var market_id: Int,
        var main_id: Int,
        var sub_id: Int,
        var market_name: String?,
        var item_name: String?,
        var item_unit: String?,
        var item_price: Int,
        var quick: Int,
        var delivery: Int,
        var user_id: Int,
        var file_key: String?,
        var favorite_flag: Int
)