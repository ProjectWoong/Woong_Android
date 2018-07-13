package com.woong.woong_android.map

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat.startActivity
import android.view.Window
import android.widget.Toast
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.location
import com.woong.woong_android.login.FirstLoginVO
import com.woong.woong_android.map.put.PutLocationRegisterResponse
import com.woong.woong_android.map.put.PutLocationRegisterResponseData
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.woong_usertoken
import io.realm.Realm
import io.realm.Realm.init
import kotlinx.android.synthetic.main.dialog_isright_location.*
import kotlinx.android.synthetic.main.dialog_payment_myproduct.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DialogIsRightLocation(activity: Activity):Dialog(activity) {
    lateinit var networkService: NetworkService
    lateinit var flRealm : Realm
    lateinit var firstLoginVO: FirstLoginVO
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
       // window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_isright_location)
        btn_cancel_location.setOnClickListener {
            dismiss()
        }
        btn_ok_location.setOnClickListener {
            networkService = ApplicationController.instance.networkService

            var longitude = location.logitude
            var latitude = location.latitude
            var real_address = location.real_address
            var user_token = woong_usertoken.user_token

            var user_id = woong_usertoken.user_id
            val putLocationRegisterResponseData = PutLocationRegisterResponseData(latitude,longitude,real_address)
            val putLocationRegister = networkService.putLocationRegister(user_token,putLocationRegisterResponseData)
            putLocationRegister.enqueue(object:Callback<PutLocationRegisterResponse>{
                override fun onFailure(call: Call<PutLocationRegisterResponse>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<PutLocationRegisterResponse>?, response: Response<PutLocationRegisterResponse>?) {
                    if(response!!.isSuccessful){
                        init()
                        Toast.makeText(context,"위치등록완료",Toast.LENGTH_SHORT).show()
                        val intent = Intent(activity,MainActivity::class.java)
                        insertUserId(user_id)
                        activity.startActivity(intent)
                        activity.finish()

                    }
                }

            })

        }
    }

    fun init(){
        Realm.init(context)
        flRealm = Realm.getDefaultInstance()
    }
    fun insertUserId(user_id:String){
        firstLoginVO = FirstLoginVO()
        firstLoginVO.user_id = user_id

        flRealm.beginTransaction()
        flRealm.copyToRealm(firstLoginVO)//memberRealm에있는 값을 복사해 넣겠다.

        flRealm.commitTransaction()
    }
}