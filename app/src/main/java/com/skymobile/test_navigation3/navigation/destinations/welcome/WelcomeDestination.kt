package com.skymobile.test_navigation3.navigation.destinations.welcome

import kotlinx.serialization.Serializable

sealed interface WelcomeDestination {
    @Serializable data object welcome : WelcomeDestination
    @Serializable data object login : WelcomeDestination
    @Serializable data object register : WelcomeDestination
}