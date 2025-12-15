package com.skymobile.test_navigation3.navigation


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named

@OptIn(ExperimentalMaterial3Api::class, KoinExperimentalAPI::class)
@Composable
fun NavRoot() {
    val entryProvider = koinEntryProvider()
    val rootNavigator = koinInject<Navigator>(named("Root"))

    NavDisplay(
        backStack = rootNavigator.backstack,
        onBack = { rootNavigator.goBack() },
        entryProvider = entryProvider
    )
}


@Serializable
sealed interface RootDestination {
    @Serializable data object Main : RootDestination
    @Serializable data object Swap : RootDestination
}

@Serializable
sealed interface MainDestination {
    @Serializable data object Home : MainDestination
    @Serializable data object Profile : MainDestination
    @Serializable data object Settings : MainDestination
}

@Serializable
sealed interface SwapDestination {
    @Serializable data object SwapAmount : SwapDestination
    @Serializable data object SwapTo : SwapDestination
    @Serializable data object SwapDetails : SwapDestination
}