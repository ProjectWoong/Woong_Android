package com.woong.woong_android.login

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class FirstLoginVO:RealmObject() {
    @PrimaryKey
    var user_id : String = ""
}