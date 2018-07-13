package com.woong.woong_android.seller_market.album

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.get.GetMarketAlbumResponse
import com.woong.woong_android.seller_market.get.GetMarketAlbumResponseData
import com.woong.woong_android.seller_market.get.GetMarketInfoResponseData
import com.woong.woong_android.woong_marketinfo
import kotlinx.android.synthetic.main.fragment_sellermarket_album.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellerMarketAlbum: Fragment() {

    lateinit var albumItems : ArrayList<GetMarketAlbumResponseData>
    lateinit var albumAdapter : AlbumAdapter
    lateinit var networkService: NetworkService
    lateinit var requestManager: RequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sellermarket_album,container,false)

        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this)

        var market_id = woong_marketinfo.market_id

        //market_id(path)
        val getMarketAlbum = networkService.getMarketAlbum(market_id)
        getMarketAlbum.enqueue(object: Callback<GetMarketAlbumResponse>{
            override fun onFailure(call: Call<GetMarketAlbumResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetMarketAlbumResponse>?, response: Response<GetMarketAlbumResponse>?) {
                if(response!!.isSuccessful){
                    albumItems = response.body().data
                    albumAdapter = AlbumAdapter(albumItems,requestManager)
                    v.rv_sellermarket_album.layoutManager = LinearLayoutManager(context)
                    v.rv_sellermarket_album.adapter = albumAdapter
                }
            }

        })

        return v
    }
}