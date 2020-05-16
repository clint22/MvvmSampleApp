package com.bestdocapp.mvvmsampleapp.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bestdocapp.mvvmsampleapp.R
import com.bestdocapp.mvvmsampleapp.databinding.ActivityMainBinding
import com.bestdocapp.mvvmsampleapp.flat.FlatActivity
import com.bestdocapp.mvvmsampleapp.showToast
import com.bestdocapp.mvvmsampleapp.validate
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
        setupViewModel()
        observeViewModel()
    }

    private fun observeViewModel() {

        loginViewModel.loginResult.observe(
            this,
            Observer { login ->
                Log.e("loginResult", Gson().toJson(login))
                if (login.status) {
                    val intent = Intent(this, FlatActivity::class.java)
                    startActivity(intent)
                    "Successfully logged in".showToast()
                } else {
                    login.message?.showToast()
                }
            }
        )
    }


    private fun setupViewModel() {

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

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

        if (validate(editTextUserName.text.toString()) && validate(
                editTextPassword.text.toString()
            )
        ) {
            loginViewModel.login(
                username = editTextUserName.text.toString(),
                password = editTextPassword.text.toString()
            )

        } else {

            "Input cannot be null".showToast()
        }
    }
}
