package com.skymobile.test_navigation3.di

import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import com.skymobile.test_navigation3.Screen
import com.skymobile.test_navigation3.navigation.MainDestination
import com.skymobile.test_navigation3.navigation.Navigator
import com.skymobile.test_navigation3.navigation.RootDestination
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val mainNavigationModule = module {

    single(named("Main")) {
        Navigator(startDestination = MainDestination.Home)
    }


    navigation<MainDestination.Home> {
        Screen(
            title = "Home",
            onClick = {
                get<Navigator>(named("Root"))
                    .navigateTo(RootDestination.Swap)
            }
        )
    }

    navigation<MainDestination.Profile> {
        Screen(title = "Profile")
    }

    navigation<MainDestination.Settings> {
        Screen(title = "Settings")
    }
}