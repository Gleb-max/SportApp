package com.sport.app.ui.tutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.sport.app.MainActivity
import com.sport.app.R
import com.sport.app.core.ext.storage
import com.sport.app.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        super.onCreate(savedInstanceState)

        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = arrayListOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment(),
            Tutorial4Fragment()
        )
        val pagerAdapter =
            TutorialViewPagerAdapter(
                fragments,
                lifecycle,
                supportFragmentManager
            )
        binding.knowingViewpager.apply {
            adapter = pagerAdapter
            isUserInputEnabled = true
        }

        binding.fabNext.setOnClickListener {
            binding.knowingViewpager.currentItem++
            if (binding.knowingViewpager.currentItem == fragments.size - 1) {
                binding.fabNext.visibility = View.GONE
                binding.btnNext.visibility = View.VISIBLE
            }
        }

        binding.btnNext.setOnClickListener {
            storage().isTutorialPassed = true
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}