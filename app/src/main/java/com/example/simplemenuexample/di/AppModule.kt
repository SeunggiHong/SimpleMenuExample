package com.example.simplemenuexample.di

import com.example.simplemenuexample.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {

    viewModel {
        MainViewModel(androidApplication())
    }

}