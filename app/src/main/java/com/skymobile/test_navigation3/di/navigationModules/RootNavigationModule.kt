package com.skymobile.test_navigation3.di.navigationModules

import com.skymobile.test_navigation3.navigation.flow.MainNavRoot
import com.skymobile.test_navigation3.navigation.flow.PortfolioNavRoot
import com.skymobile.test_navigation3.navigation.utils.Navigator
import com.skymobile.test_navigation3.navigation.destinations.RootDestination
import com.skymobile.test_navigation3.navigation.destinations.portfolio.rootNavigator
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val rootNavigationModule = module {

    single(named("Root")) {
        Navigator(startDestination = RootDestination.Empty)
    }


    navigation<RootDestination.Main> {
        PortfolioNavRoot()
    }

    navigation<RootDestination.Welcome> {
        MainNavRoot(
            navigatorQualifier = "Welcome",
            onExitFlow = {
                rootNavigator().popBackStack()
            }
        )
    }

    navigation<RootDestination.Swap> {
        MainNavRoot(
            navigatorQualifier = "Swap",
            onExitFlow = {
                rootNavigator().popBackStack()
            }
        )
    }
}