package com.skymobile.test_navigation3.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.skymobile.test_navigation3.navigation.flow.NavRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val startWelcome = intent.getBooleanExtra(
            "MAIN",
            false
        )

        setContent {
            NavRoot(startWelcome)
        }
    }
}

