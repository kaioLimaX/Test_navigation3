package com.skymobile.test_navigation3.navigation.destinations.portfolio

import kotlinx.serialization.Serializable

@Serializable
sealed interface PortfolioDestination {
    @Serializable data object Home : PortfolioDestination
    @Serializable data object Profile : PortfolioDestination
    @Serializable data object Settings : PortfolioDestination
}