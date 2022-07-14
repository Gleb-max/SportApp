package com.sport.app.data

import android.content.Context
import androidx.core.content.edit

class StupidStorage(context: Context) {
    private val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    var isTutorialPassed: Boolean
        get() = prefs.getBoolean(PREF_TUTORIAL_PASSED, false)
        set(value) = prefs.edit(commit = true) { putBoolean(PREF_TUTORIAL_PASSED, value) }

    companion object {
        const val PREFS = "main_preferences"
        const val PREF_TUTORIAL_PASSED = "tutorial_passed"
    }
}