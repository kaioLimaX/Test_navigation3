package com.skymobile.test_navigation3.navigation.flow


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation3.ui.NavDisplay
import com.skymobile.test_navigation3.navigation.destinations.RootDestination
import com.skymobile.test_navigation3.navigation.utils.Navigator
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named

@OptIn(ExperimentalMaterial3Api::class, KoinExperimentalAPI::class)
@Composable
fun NavRoot(
    startWelcome: Boolean
) {
    val entryProvider = koinEntryProvider()
    val rootNavigator = koinInject<Navigator>(named("Root"))

    LaunchedEffect(startWelcome) {
        val startDestination = if (startWelcome) {
            RootDestination.Welcome
        } else {
            RootDestination.Main
        }

        rootNavigator.replaceStack(startDestination)
    }

    val current = rootNavigator.backstack.firstOrNull()
    if (current == RootDestination.Empty || current == null) {
        return
    }

    NavDisplay(
        backStack = rootNavigator.backstack,
        onBack = { rootNavigator.popBackStack() },
        entryProvider = entryProvider
    )
}