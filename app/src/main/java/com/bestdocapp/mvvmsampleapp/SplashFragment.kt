package com.bestdocapp.mvvmsampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.bestdocapp.mvvmsampleapp.databinding.FragmentSplashBinding

/**
 * This fragment will determine if the user is logged in or not
 * */
class SplashFragment : Fragment() {


    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater)
        initViews()
        return binding.root
    }

    private fun initViews() {

        binding.lottieLoadingAnimation.startLottieAnimation()
        checkIfLoggedIn()
    }

    private fun checkIfLoggedIn() {

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        if (getStringSharedPreference(SHARED_PREF_USER_TOKEN) != null) {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment, null, options)
        } else {
            findNavController().navigate(R.id.action_splashFragment_to_flatFragment, null, options)
        }
    }


}
