package com.skymobile.test_navigation3.navigation.utils

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class Navigator(startDestination : Any) {
    val backstack : SnapshotStateList<Any> = mutableStateListOf(startDestination)

    fun navigateTo(destination: Any) {
        backstack.add(destination)
    }

    fun popBackStack(): Boolean {
        if (backstack.size <= 1) return false
        backstack.removeLastOrNull()
        return true
    }

    fun canGoBack(): Boolean =
        backstack.size > 1

    fun replaceStack(destination: Any) {
        backstack.clear()
        backstack.add(destination)
    }
}