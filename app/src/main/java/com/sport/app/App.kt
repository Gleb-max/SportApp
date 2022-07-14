package com.sport.app

import android.app.Application
import com.sport.app.data.StupidStorage

class App : Application() {
    lateinit var storage: StupidStorage

    override fun onCreate() {
        super.onCreate()

        storage = StupidStorage(this)
    }
}