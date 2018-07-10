package com.woong.woong_android.notice.deliveryandreview.review_write.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import com.woong.woong_android.notice.deliveryandreview.NoticeDeliveryAndReview
import com.woong.woong_android.notice.deliveryandreview.review_write.ReviewWriteActivity
import kotlinx.android.synthetic.main.dialog_payment_myproduct.*
import kotlinx.android.synthetic.main.dialog_register_review.*

class ReviewRegisterDialog(activity: Activity) : Dialog(activity) {

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_register_review)
        this.setCancelable(false) //뒤로가기,터치 무력화

        btn_ok_rwdialog.setOnClickListener {
            dismiss()
            activity.finish()

        }



    }
}