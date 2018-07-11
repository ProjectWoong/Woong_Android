package com.woong.woong_android.seller_market.get

data class GetMarketReviewResponse (
        var message : String?,
        var rate : RateMarketReviewData,
        //이미지 아직 안되서 데이터 안받았습니다. var images
        var reviews : ArrayList<GetMarketReviewResponseData>
)