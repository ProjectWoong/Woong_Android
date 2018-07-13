package com.woong.woong_android.notice.post

data class ReviewWriteData (
        var rate_speed: Int,
        var rate_taste: Int,
        var rate_fresh: Int,
        var rate_kindness: Int,
        var content: String?,
        var file: ArrayList<ReviewImageData>
)