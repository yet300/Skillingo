package com.hadj.skillingo

import android.app.Application
import com.hadj.skillingo.di.initKoin
import org.koin.android.ext.koin.androidContext

class SkillingoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin() {
            androidContext(this@SkillingoApp)
        }
    }
}