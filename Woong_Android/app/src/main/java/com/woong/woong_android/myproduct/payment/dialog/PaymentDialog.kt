package com.woong.woong_android.myproduct.payment.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.dialog_payment_myproduct.*

class PaymentDialog(context: Context) : Dialog(context) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_payment_myproduct)
        btn_ok_pmdialog.setOnClickListener {
            dismiss()
        }
    }
}