package com.skymobile.test_navigation3.di

import android.app.Application

import com.skymobile.test_navigation3.di.navigationModules.rootNavigationModule
import com.skymobile.test_navigation3.navigation.destinations.portfolio.portfolioNavigationModule
import com.skymobile.test_navigation3.navigation.destinations.swap.swapNavigationModule
import com.skymobile.test_navigation3.navigation.destinations.welcome.welcomeNavigationModule
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
    portfolioNavigationModule,
    welcomeNavigationModule,
    swapNavigationModule,

)