package com.bestdocapp.mvvmsampleapp.flat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bestdocapp.mvvmsampleapp.databinding.FragmentFlatBinding

class FlatFragment : Fragment() {
    private lateinit var binding: FragmentFlatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFlatBinding.inflate(layoutInflater)
        return binding.root
    }


}
