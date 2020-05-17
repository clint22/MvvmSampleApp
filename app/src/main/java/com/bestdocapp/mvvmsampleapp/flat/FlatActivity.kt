package com.bestdocapp.mvvmsampleapp.flat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bestdocapp.mvvmsampleapp.R
import com.bestdocapp.mvvmsampleapp.SHARED_PREF_USER_TOKEN
import com.bestdocapp.mvvmsampleapp.getStringSharedPreference

class FlatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat)
        Log.e("Token is : ", "Token" + " " + getStringSharedPreference(SHARED_PREF_USER_TOKEN))

    }

    override fun onBackPressed() {
//        super.onBackPressed()
    }
}
