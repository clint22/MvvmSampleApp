package com.bestdocapp.mvvmsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * This activity will hold the Navigation host fragment
 *  */

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_new)
    }
}
