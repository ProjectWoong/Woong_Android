package com.woong.woong_android.tutorial

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.woong.woong_android.R
import com.woong.woong_android.login.LoginActivity
import kotlinx.android.synthetic.main.activity_tutorial.*

class TutorialActivity : AppCompatActivity() {
    val bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        addFragment(Tutorial1())
        btn_skip_tutorial.setOnClickListener{
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun addFragment(fragment: Fragment) {

        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.add(R.id.frame_tutorial,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.frame_tutorial,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
