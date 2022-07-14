package com.sport.app.ui.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sport.app.databinding.FragmentTutorial3Binding

class Tutorial3Fragment : Fragment() {
    private lateinit var binding: FragmentTutorial3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTutorial3Binding.inflate(inflater, container, false)
        return binding.root
    }
}