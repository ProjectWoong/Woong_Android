package com.woong.woong_android.seller_market.review

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.bumptech.glide.Glide
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.dialog_image_review.*
import kotlinx.android.synthetic.main.dialog_payment_myproduct.*

class ImageDialog(context: Context?,img : String?):Dialog(context) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_image_review)
        Glide.with(context).load(img).into(iv_imglarge_review)
        btn_closeimg_review.setOnClickListener {
            dismiss()
        }
    }
}