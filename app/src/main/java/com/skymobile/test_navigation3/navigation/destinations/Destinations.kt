package com.skymobile.test_navigation3.navigation.destinations

import kotlinx.serialization.Serializable

sealed interface WelcomeDestination {
    @Serializable data object welcome : WelcomeDestination
    @Serializable data object login : WelcomeDestination
    @Serializable data object register : WelcomeDestination
}

@Serializable
sealed interface PortfolioDestination {
    @Serializable data object Home : PortfolioDestination
    @Serializable data object Profile : PortfolioDestination
    @Serializable data object Settings : PortfolioDestination
}