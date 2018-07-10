package com.woong.woong_android.myproduct.payment.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.dialog_payment_myproduct.*

class FailPaymentDialog(activity: Activity) : Dialog(activity) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_fail_payment_product)
        btn_ok_pmdialog.setOnClickListener {
            dismiss()
        }
    }
}