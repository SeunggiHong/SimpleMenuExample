package com.example.simplemenuexample.utils

import android.app.Application
import android.util.Log
import com.example.simplemenuexample.di.appModule
import com.example.simplemenuexample.di.appTestModule
import com.example.simplemenuexample.utils.Constants.TAG
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App :Application() {
    companion object {
        lateinit var instance: App
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this@App

        startKoin {
            androidContext(this@App)
            Log.d(TAG, "App - startKoin..")
            modules(
                listOf(appModule, appTestModule)
            )
        }

    }
}