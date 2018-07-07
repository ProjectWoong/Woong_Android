package com.woong.woong_android.network

import com.woong.woong_android.map.get.GetLocationListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkService{
    @GET("v2/local/search/keyword.json")
    fun getLocationList(@Header("Authorization") header: String,
                        @Query("query") query: String): Call<GetLocationListResponse>

}