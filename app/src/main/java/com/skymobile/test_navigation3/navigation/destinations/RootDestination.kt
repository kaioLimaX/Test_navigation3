package com.skymobile.test_navigation3.navigation.destinations

import kotlinx.serialization.Serializable

@Serializable
sealed interface RootDestination {
    val typeName: String

    @Serializable
    data object Empty : RootDestination {
        override val typeName: String = "Empty"
    }
    @Serializable
    data object Welcome : RootDestination {
        override val typeName: String get() = "Welcome"
    }
    @Serializable
    data object Main : RootDestination {
        override val typeName: String get() = "Main"
    }
    @Serializable
    data object Swap : RootDestination {
        override val typeName: String get() = "Swap"
    }
}