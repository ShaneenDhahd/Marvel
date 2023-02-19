package com.gateway.marvel.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelModule: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}