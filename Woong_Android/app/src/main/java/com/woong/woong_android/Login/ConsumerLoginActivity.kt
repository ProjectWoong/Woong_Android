package com.woong.woong_android.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.woong.woong_android.join.consumer.TermsActivity
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.login.post.PostSignInAppResponse
import com.woong.woong_android.login.post.PostSignInAppResponseData
import com.woong.woong_android.MainActivity
import com.woong.woong_android.map.MapActivity
import com.woong.woong_android.myproduct.payment.dialog.PaymentDialog
import com.woong.woong_android.woong_usertoken
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_consumer_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConsumerLoginActivity : AppCompatActivity() {
    lateinit var networkService: NetworkService
    lateinit var flRealm:Realm
    lateinit var firstLoginVO: FirstLoginVO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_login)

        val dialog = PaymentDialog(this)

        networkService = ApplicationController.instance.networkService
        btn_login_consumer_login.setOnClickListener {
            var consumer_id = id_consume_login.text.toString()
            var consumer_pwd = pwd_consume_login.text.toString()
            val postSignInAppResponseData = PostSignInAppResponseData(consumer_id,consumer_pwd)


            val postSigninApp = networkService.postSignInApp(postSignInAppResponseData)
            postSigninApp.enqueue(object:Callback<PostSignInAppResponse>{
                override fun onFailure(call: Call<PostSignInAppResponse>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<PostSignInAppResponse>?, response: Response<PostSignInAppResponse>?) {
                    if(response!!.isSuccessful){
                        init()
                        var user_token = response.body().data.token

                        if(getUserId(consumer_id).isEmpty()){
                            val intent = Intent(applicationContext, MapActivity::class.java)
                            woong_usertoken.user_id = consumer_id
                            woong_usertoken.user_token = user_token

                            startActivity(intent)   // 전환될 액티비티로 넘어갈때

                        }else{
                            val intent = Intent(applicationContext,MainActivity::class.java)
                            intent.putExtra("user_token",user_token)// getActivity: 현재 액티비티를 가져옴
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                            woong_usertoken.user_token = user_token

                            startActivity(intent)   // 전환될 액티비티로 넘어갈때
                        }

                    }

                }

            })



        }
        tv_signup_consumer_login.setOnClickListener {
            val intent = Intent(applicationContext, TermsActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
        btn_fb_login.setOnClickListener {
            dialog.show()
        }
        btn_google_login.setOnClickListener {
            dialog.show()
        }
        btn_kakao_login.setOnClickListener {
            dialog.show()
        }
    }

    fun init(){
        Realm.init(this)
        flRealm = Realm.getDefaultInstance()
    }
    fun insertUserId(user_id:String){
        firstLoginVO = FirstLoginVO()
        firstLoginVO.user_id = user_id

        flRealm.beginTransaction()
        flRealm.copyToRealm(firstLoginVO)//memberRealm에있는 값을 복사해 넣겠다.

        flRealm.commitTransaction()
    }
    fun deleteUserId(id:String){
        val result = flRealm.where(FirstLoginVO::class.java)
                .equalTo("user_id",id)
                .findAll()

        if(result.isEmpty()){
            return
        }
        flRealm.beginTransaction() //수정을 위한
        result.deleteAllFromRealm()//네임과 일치하는걸 뺴고 렘에서 다 지운다.
        flRealm.commitTransaction()
        // Toast.makeText(this,"삭제성공", Toast.LENGTH_SHORT).show()

    }


    fun getUserId(user_id:String) : RealmResults<FirstLoginVO> {
        return flRealm.where(FirstLoginVO::class.java).equalTo("user_id", user_id).findAll()
    }
}
