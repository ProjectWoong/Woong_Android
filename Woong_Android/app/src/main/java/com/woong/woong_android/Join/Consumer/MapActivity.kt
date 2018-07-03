package com.woong.woong_android.Join.Consumer

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import net.daum.mf.map.api.MapView
import com.woong.woong_android.R
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


//참고사이트 http://es1015.tistory.com/296
class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        /* 키해쉬*/
        try {
            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        val mapView = MapView(this)
        mapView.setDaumMapApiKey("5b9f84f71895898003a9683274d06a39")
        val container = findViewById<View>(R.id.map_view) as RelativeLayout

        container.addView(mapView)
    }
}
