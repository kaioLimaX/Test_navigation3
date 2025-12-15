package com.skymobile.test_navigation3.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class Navigator(startDestination : Any) {
    val backstack : SnapshotStateList<Any> = mutableStateListOf(startDestination)

    fun navigateTo(destination: Any) {
        backstack.add(destination)
    }

    fun goBack(){
        backstack.removeLastOrNull()
    }
}