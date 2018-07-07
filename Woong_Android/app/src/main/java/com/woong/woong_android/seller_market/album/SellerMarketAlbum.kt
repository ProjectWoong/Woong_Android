package com.woong.woong_android.seller_market.album

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.fragment_sellermarket_album.view.*

class SellerMarketAlbum: Fragment() {

    lateinit var albumItems : ArrayList<AlbumItem>
    lateinit var albumAdapter : AlbumAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sellermarket_album,container,false)

        albumItems = ArrayList()
        albumItems.add(AlbumItem("2018년 7월 7일", R.drawable.rv_item_image, ";;;"))

        albumAdapter = AlbumAdapter(albumItems)
        v.rv_sellermarket_album.layoutManager = LinearLayoutManager(context)
        v.rv_sellermarket_album.adapter = albumAdapter

        return v
    }
}