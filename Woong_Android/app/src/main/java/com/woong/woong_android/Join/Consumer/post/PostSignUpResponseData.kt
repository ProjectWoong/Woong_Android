package com.woong.woong_android.Join.Consumer.post

data class PostSignUpResponseData (
        var birth : String?,
        var user_name : String?,
        var email : String?,
        var password : String?,
        var phone_number : String?,
        var login_type : Int,
        var use_type : Int,
        var allergy : ArrayList<String>
)