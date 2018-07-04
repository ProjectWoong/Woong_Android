package com.woong.woong_android.myproduct.payment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.WindowManager
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.adapter.MyProductPaymentAdapter
import com.woong.woong_android.myproduct.data.MyProductPaymentData
import com.woong.woong_android.myproduct.payment.dialog.PaymentDialog
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {

    lateinit var myProductPaymentAdapter: MyProductPaymentAdapter
    lateinit var paymentItems : ArrayList<MyProductPaymentData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        var displayMetrics = applicationContext.resources.displayMetrics
        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels

        var payment_dialog = PaymentDialog(this)

        var wm : WindowManager.LayoutParams = payment_dialog.window.attributes
        wm.copyFrom(payment_dialog.window.attributes)
        wm.width = width-200
        wm.height = height-600

        paymentItems= ArrayList()

        paymentItems.add(MyProductPaymentData("[복순마켓] 흙감자"))
        paymentItems.add(MyProductPaymentData("[영떠마켓] 브로콜리"))
        paymentItems.add(MyProductPaymentData("[수뎡마켓] 생감자"))
        paymentItems.add(MyProductPaymentData("[점례마켓] 싱싱배추"))

        myProductPaymentAdapter = MyProductPaymentAdapter(paymentItems)

        rv_payment_myproduct.layoutManager = LinearLayoutManager(this)
        rv_payment_myproduct.adapter = myProductPaymentAdapter

        btn_pay_myproduct.setOnClickListener {
            payment_dialog.show()

        }




    }
}
