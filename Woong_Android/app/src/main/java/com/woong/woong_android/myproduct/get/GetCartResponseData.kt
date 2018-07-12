package com.woong.woong_android.myproduct.get

data class GetCartResponseData (
        var market_id: Int,
        var item_id: Int,
        var carttitle: String?,
        var file_key: String?,
        var packging: String?,
        var item_price: Int,
        var item_unit: String?,
        var delivery: Int
)