package com.skymobile.test_navigation3.navigation.destinations.welcome

import com.skymobile.test_navigation3.ui.Screen
import com.skymobile.test_navigation3.navigation.utils.Navigator
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val welcomeNavigationModule = module {

    single(named("Welcome")) {
        Navigator(startDestination = WelcomeDestination.login)
    }

    navigation<WelcomeDestination.welcome> {
        Screen(
            title = "welcome"
        )
    }

    navigation<WelcomeDestination.login> {
        Screen(
            title = "Home"
        )
    }

    navigation<WelcomeDestination.register> {
        Screen(title = "Profile")
    }
}