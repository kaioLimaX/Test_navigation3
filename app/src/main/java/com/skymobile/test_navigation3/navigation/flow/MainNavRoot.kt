package com.skymobile.test_navigation3.navigation.flow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation3.ui.NavDisplay
import com.skymobile.test_navigation3.navigation.utils.LocalFlowBack
import com.skymobile.test_navigation3.navigation.utils.Navigator
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named

@OptIn(KoinExperimentalAPI::class)
@Composable
fun MainNavRoot(
    navigatorQualifier: String,
    onExitFlow: () -> Unit
) {
    val entryProvider = koinEntryProvider()
    val flowNavigator = koinInject<Navigator>(named(navigatorQualifier))

    val onBack: () -> Unit = {
        if (flowNavigator.canGoBack()) {
            flowNavigator.popBackStack()
        } else {
            onExitFlow()
        }
    }

    CompositionLocalProvider(
        LocalFlowBack provides onBack
    ) {
        NavDisplay(
            backStack = flowNavigator.backstack,
            onBack = onBack,
            entryProvider = entryProvider
        )
    }
}