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

        if (validate(editTextUserName.text.toString()) && validate(editTextPassword.text.toString())) {

            "Successfully logged in".showToast()

        } else {

            "Input cannot be null".showToast()
        }
    }
}
