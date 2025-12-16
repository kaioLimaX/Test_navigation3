package com.skymobile.test_navigation3.di.navigationModules

import androidx.compose.runtime.Composable
import com.skymobile.test_navigation3.Screen
import com.skymobile.test_navigation3.navigation.utils.Navigator
import com.skymobile.test_navigation3.navigation.destinations.PortfolioDestination
import com.skymobile.test_navigation3.navigation.destinations.RootDestination
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.getKoin
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val mainNavigationModule = module {

    single(named("Main")) {
        Navigator(startDestination = PortfolioDestination.Home)
    }


    navigation<PortfolioDestination.Home> {
        Screen(
            title = "Home",
            onClick = {
               rootNavigator().navigateTo(RootDestination.Swap)
            }
        )
    }

    navigation<PortfolioDestination.Profile> {
        Screen(title = "Profile")
    }

    navigation<PortfolioDestination.Settings> {
        Screen(title = "Settings")
    }


}

fun rootNavigator(): Navigator {
    return getKoin().get(qualifier = named("Root"))
}