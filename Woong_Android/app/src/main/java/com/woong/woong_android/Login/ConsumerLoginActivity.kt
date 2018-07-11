package com.woong.woong_android.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.join.consumer.TermsActivity
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.Login.post.PostSignInAppResponse
import com.woong.woong_android.Login.post.PostSignInAppResponseData
import kotlinx.android.synthetic.main.activity_consumer_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConsumerLoginActivity : AppCompatActivity() {
    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_login)

        networkService = ApplicationController.instance.networkService
        btn_login_consumer_login.setOnClickListener {
            var consumer_id = id_consume_login.text.toString()
            var consumer_pwd = pwd_consume_login.text.toString()
            val postSignInAppResponseData = PostSignInAppResponseData(consumer_id,consumer_pwd)

            val postSigninApp = networkService.postMarketSignInApp(postSignInAppResponseData)
            postSigninApp.enqueue(object:Callback<PostSignInAppResponse>{
                override fun onFailure(call: Call<PostSignInAppResponse>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<PostSignInAppResponse>?, response: Response<PostSignInAppResponse>?) {
                    if(response!!.isSuccessful){
                        var user_token = response.body().data.token
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        intent.putExtra("user_token",user_token)// getActivity: 현재 액티비티를 가져옴
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)


                        startActivity(intent)   // 전환될 액티비티로 넘어갈때
                    }

                }

            })



        }
        tv_signup_consumer_login.setOnClickListener {
            val intent = Intent(applicationContext, TermsActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
    }
}
