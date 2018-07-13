package com.woong.woong_android

import android.app.Activity
import android.content.Context
import com.woong.woong_android.home.main.Idx.idx

object SharedReferenceController {
    private val FLAG = "flag"

    fun setFlag(context: Context, flag:Int ){
        val pref = context.getSharedPreferences(FLAG, Activity.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putInt(FLAG,flag)
        editor.commit()
    }
    fun getFlag(context: Context):Int{
        val pref = context.getSharedPreferences(FLAG, Activity.MODE_PRIVATE)
        return pref.getInt(FLAG,0)
    }


}