package com.woong.woong_android.Login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginTab : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_login, container, false)
        v.btn_consumer_login.setOnClickListener {
            replaceFragment(ConsumerLoginTab())
        }
        return v
    }
    fun replaceFragment(fragment: Fragment) {
        val fm = activity!!.supportFragmentManager  // 프래그먼트에서 부를때 activity!!
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.login_frame, fragment)
        transaction.addToBackStack(null)    // 이전 상태를 백스택에 추가하여 사용자가 백버튼을 눌렀을때에 대한 호환성 추가
        transaction.commit()
    }
}