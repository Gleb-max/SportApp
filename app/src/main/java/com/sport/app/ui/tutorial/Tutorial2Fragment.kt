package com.sport.app.ui.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sport.app.databinding.FragmentTutorial2Binding

class Tutorial2Fragment: Fragment() {
    private lateinit var binding: FragmentTutorial2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTutorial2Binding.inflate(inflater, container, false)
        return binding.root
    }
}