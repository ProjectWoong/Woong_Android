package com.woong.woong_android.notice.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.notice.data.PhotoData
import com.woong.woong_android.notice.deliveryandreview.review_write.ReviewWriteActivity
import com.woong.woong_android.notice.viewholder.NtPhotoViewHolder

class NtPhotoAdapter(private var photoItems : ArrayList<PhotoData>,var requestManager: RequestManager) : RecyclerView.Adapter<NtPhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NtPhotoViewHolder {
        val mainView  = LayoutInflater.from(parent.context).inflate(R.layout.item_photo_review,parent,false)
        return NtPhotoViewHolder(mainView)
    }

    override fun getItemCount(): Int =photoItems.size

    override fun onBindViewHolder(holder: NtPhotoViewHolder, position: Int) {
        requestManager.load(photoItems[position].review_img).centerCrop().into(holder.review_photo)
        holder.cancel_btn.setOnClickListener{
            photoItems.removeAt(position)
            this.notifyDataSetChanged()
        }
    }
}