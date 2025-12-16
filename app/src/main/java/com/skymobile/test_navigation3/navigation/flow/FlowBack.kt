package com.skymobile.test_navigation3.navigation.flow

import androidx.compose.runtime.staticCompositionLocalOf

val LocalFlowBack = staticCompositionLocalOf<() -> Unit> {
    error("FlowBack not provided")
}