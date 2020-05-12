package com.bestdocapp.mvvmsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bestdocapp.mvvmsampleapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.txtSubmit.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.txtSubmit -> {
                callLogin()
            }
        }
    }

    private fun callLogin() {
        /* https://www.youtube.com/watch?v=tNsW-Vl0mX4
        Watch this video to know more about local functions in Kotlin */
        fun validate(username: String, password: String) {
            if (username.isEmpty() || password.isEmpty()) {
                "Input cannot be empty".showToast()
            } else {
                "Successfully Logged in".showToast()
            }
        }
        validate(
            username = editTextUserName.text.toString(),
            password = editTextPassword.text.toString()
        )
    }
}
