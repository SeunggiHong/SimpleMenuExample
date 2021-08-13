package com.example.simplemenuexample.utils

import android.app.Application
import android.util.Log
import com.example.simplemenuexample.di.appModule
import com.example.simplemenuexample.utils.Constants.TAG
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App :Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            Log.d(TAG, "App - startKoin..")
            modules(
                appModule
            )
        }

    }
}