package com.skymobile.test_navigation3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.ui.NavDisplay
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named

@OptIn(KoinExperimentalAPI::class)
@Composable
fun SwapNavRoot() {
    val entryProvider = koinEntryProvider()
    val swapNavigator = koinInject<Navigator>(named("Swap"))
    val rootNavigator = koinInject<Navigator>(named("Root"))

    NavDisplay(
        backStack = swapNavigator.backstack,
        onBack = {
            if (swapNavigator.backstack.size > 1) {
                swapNavigator.goBack()
            } else {
                rootNavigator.goBack()
            }
        },
        entryProvider = entryProvider
    )
}