package com.bestdocapp.mvvmsampleapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bestdocapp.mvvmsampleapp.databinding.ActivitySplashBinding
import com.bestdocapp.mvvmsampleapp.flat.FlatActivity
import com.bestdocapp.mvvmsampleapp.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {

        binding.lottieLoadingAnimation.startLottieAnimation()
        checkIfLoggedIn()

    }


    private fun checkIfLoggedIn() {

        if (getStringSharedPreference(SHARED_PREF_USER_TOKEN).equals(SHARED_PREF_USER_TOKEN)) {
            val intent = Intent(this, FlatActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
