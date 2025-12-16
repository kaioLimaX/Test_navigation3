package com.skymobile.test_navigation3.di

import android.app.Application
import com.skymobile.test_navigation3.di.navigationModules.mainNavigationModule
import com.skymobile.test_navigation3.di.navigationModules.rootNavigationModule
import com.skymobile.test_navigation3.navigation.swap.swapNavigationModule
import com.skymobile.test_navigation3.di.navigationModules.welcomeNavigationModule
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(getNavigationModules())
        }
    }
}

fun getNavigationModules() = listOf(
    rootNavigationModule,
    mainNavigationModule,
    welcomeNavigationModule,
    swapNavigationModule,

)