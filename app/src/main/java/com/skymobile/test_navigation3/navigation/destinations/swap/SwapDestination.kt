package com.skymobile.test_navigation3.navigation.destinations.swap

import kotlinx.serialization.Serializable

@Serializable
sealed interface SwapDestination {
    @Serializable data object SwapAmount : SwapDestination
    @Serializable data object SwapTo : SwapDestination
    @Serializable data object SwapDetails : SwapDestination
}