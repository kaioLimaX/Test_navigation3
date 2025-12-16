package com.skymobile.test_navigation3.navigation.destinations.swap


import com.skymobile.test_navigation3.ui.Screen
import com.skymobile.test_navigation3.ui.Screen2
import com.skymobile.test_navigation3.navigation.utils.Navigator
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val swapNavigationModule = module {

    single(named("Swap")) {
        Navigator(startDestination = SwapDestination.SwapAmount)
    }

    navigation<SwapDestination.SwapAmount> {
        Screen2(
            title = "Swap Amount",
            onClick = {
                get<Navigator>(named("Swap"))
                    .navigateTo(SwapDestination.SwapTo)
            }
        )
    }

    navigation<SwapDestination.SwapTo> {
        Screen2(
            title = "Swap To",
            onClick = {
                get<Navigator>(named("Swap"))
                    .navigateTo(SwapDestination.SwapDetails)
            }
        )
    }

    navigation<SwapDestination.SwapDetails> {
        Screen(title = "Swap Details")
    }
}