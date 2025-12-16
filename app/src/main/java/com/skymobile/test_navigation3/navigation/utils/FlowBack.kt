package com.skymobile.test_navigation3.navigation.utils

import androidx.compose.runtime.staticCompositionLocalOf

val LocalFlowBack = staticCompositionLocalOf<() -> Unit> {
    error("FlowBack not provided")
}