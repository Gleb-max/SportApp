package com.sport.app.core.ext

import android.content.Context
import com.sport.app.App
import com.sport.app.data.StupidStorage

fun Context.app(): App = applicationContext as App
fun Context.storage(): StupidStorage = app().storage