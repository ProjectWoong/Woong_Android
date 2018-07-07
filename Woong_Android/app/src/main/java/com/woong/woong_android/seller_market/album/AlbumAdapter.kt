package com.woong.woong_android.seller_market.album

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R

class AlbumAdapter(var albumItems : ArrayList<AlbumItem>) : RecyclerView.Adapter<AlbumViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_sellermarket_album, parent, false)
        return AlbumViewHolder(mainView)
    }

    override fun getItemCount(): Int = albumItems.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.albumDate.text = albumItems[position].albumDate
        holder.albumPhoto.setImageResource(albumItems[position].albumPhoto)
        holder.albumContent.text = albumItems[position].albumContent
    }

}