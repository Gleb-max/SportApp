package com.sport.app.ui.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sport.app.databinding.FragmentTutorial1Binding

class Tutorial1Fragment : Fragment() {
    private lateinit var binding: FragmentTutorial1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTutorial1Binding.inflate(inflater, container, false)
        return binding.root
    }
}