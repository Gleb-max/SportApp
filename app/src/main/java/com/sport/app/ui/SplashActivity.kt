package com.sport.app.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sport.app.MainActivity
import com.sport.app.R
import com.sport.app.core.ext.storage
import com.sport.app.ui.tutorial.TutorialActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_HackSportApp)

        launchNextIntent()
    }

    private fun launchNextIntent() {
        val newIntent = when {
            storage().isTutorialPassed -> Intent(this, MainActivity::class.java)
            else -> Intent(this, TutorialActivity::class.java)
        }
        startActivity(newIntent)
        finish()
    }
}