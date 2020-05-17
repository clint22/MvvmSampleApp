package com.bestdocapp.mvvmsampleapp.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.bestdocapp.mvvmsampleapp.*
import com.bestdocapp.mvvmsampleapp.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.activity_main.*


class LoginFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setClickListeners()
        setupViewModel()
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel() {

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        loginViewModel.loginResult.observe(
            this.requireActivity(),
            Observer { login ->
                binding.lottieLoadingAnimation.stopLottieAnimation()
                if (login.status) {
                    login.token?.setStringSharedPreference(SHARED_PREF_USER_TOKEN)
                    findNavController().navigate(R.id.flatFragment, null, options)
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
            binding.lottieLoadingAnimation.startLottieAnimation()
            loginViewModel.login(
                username = editTextUserName.text.toString(),
                password = editTextPassword.text.toString()
            )

        } else {

            "Input cannot be null".showToast()
        }
    }


}
