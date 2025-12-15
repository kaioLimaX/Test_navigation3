package com.skymobile.test_navigation3.di

import android.app.Application
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(mainNavigationModule, rootNavigationModule,swapNavigationModule)
        }
    }
}