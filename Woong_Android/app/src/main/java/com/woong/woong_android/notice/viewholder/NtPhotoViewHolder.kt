package com.woong.woong_android.notice.viewholder

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.woong.woong_android.R

class NtPhotoViewHolder(itemView: View?):RecyclerView.ViewHolder(itemView) {
    var review_photo : ImageView = itemView!!.findViewById(R.id.img_photo_review) as ImageView
    var cancel_btn : ImageView = itemView!!.findViewById(R.id.btn_cancel_photo) as ImageView
}