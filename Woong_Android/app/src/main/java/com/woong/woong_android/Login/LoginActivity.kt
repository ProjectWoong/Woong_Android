package com.woong.woong_android.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_consumer_login.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        addFragment(LoginTab())
    }

    fun addFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        // transaction: Activity에 행하는 변화들
        val transaction = fm.beginTransaction()
        transaction.add(R.id.login_frame, fragment)
        transaction.commit()    // 동시에 실행
    }


}
