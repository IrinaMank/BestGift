package com.giffter.bestgift

import android.app.Application
import com.giffter.bestgift.ui.di.appModule
import org.koin.android.ext.android.startKoin
import org.koin.core.Koin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }

}