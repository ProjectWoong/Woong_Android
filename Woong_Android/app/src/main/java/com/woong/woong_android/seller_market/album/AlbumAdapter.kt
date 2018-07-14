package com.woong.woong_android.seller_market.album

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.seller_market.get.GetMarketAlbumResponseData
import com.woong.woong_android.seller_market.get.GetMarketInfoResponseData

class AlbumAdapter(var albumItems : ArrayList<GetMarketAlbumResponseData>,var requestManager: RequestManager) : RecyclerView.Adapter<AlbumViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_sellermarket_album, parent, false)
        return AlbumViewHolder(mainView)
    }

    override fun getItemCount(): Int = albumItems.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.albumDate.text = albumItems[position].cr_dt
        requestManager.load(albumItems[position].file_key).apply {
            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
        }.into(holder.albumPhoto)
        holder.albumContent.text = "#"+albumItems[position].album_title
    }

}