package com.skymobile.test_navigation3.di

import com.skymobile.test_navigation3.navigation.MainNavRoot
import com.skymobile.test_navigation3.navigation.Navigator
import com.skymobile.test_navigation3.navigation.RootDestination
import com.skymobile.test_navigation3.navigation.SwapNavRoot
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val rootNavigationModule = module {

    single(named("Root")) {
        Navigator(startDestination = RootDestination.Main)
    }

    navigation<RootDestination.Main> {
        MainNavRoot()
    }

    navigation<RootDestination.Swap> {
        SwapNavRoot()
    }
}