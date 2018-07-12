package com.woong.woong_android.join.consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_consumer_join2.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class Join2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_join2)


        btn_next_consumer_join2.setOnClickListener {
            var birth = intent.getStringExtra("birth")
            var name = intent.getStringExtra("name")

            var email = email_join_consumer.text.toString()
            var pwd = pwd_join_consumer.text.toString()
            var phone = phone_join_consumer.text.toString()

            val phone_p = Pattern.compile("(^[0-9]*\$)")
            val m = phone_p.matcher(phone)

            Log.v("버쓰",birth)
            if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()&&m.matches()){
                val intent = Intent(applicationContext,AllergyActivity::class.java)
                intent.putExtra("birth",birth)
                intent.putExtra("name",name)
                intent.putExtra("email",email)
                intent.putExtra("pwd",pwd)
                intent.putExtra("phone",phone)
                startActivity(intent)   // 전환될 액티비티로 넘어갈때
            }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()&&m.matches()) {
                Toast.makeText(applicationContext, "올바른 이메일 주소로 입력해주세요", Toast.LENGTH_SHORT).show()

            }else if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()&&!m.matches()){
                Toast.makeText(applicationContext, "전화번호를 올바르게 입력해주세요", Toast.LENGTH_SHORT).show()

            }else {
                Toast.makeText(applicationContext, "올바른 이메일 주소로 입력해주세요", Toast.LENGTH_SHORT).show()
                Toast.makeText(applicationContext, "전화번호를 올바르게 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
