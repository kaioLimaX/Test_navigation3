package com.skymobile.test_navigation3.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.skymobile.test_navigation3.navigation.utils.LocalFlowBack

@Composable
fun Screen(title: String, onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title)
        Button(onClick = {
            onClick()
        }) {
            Text("Button $title")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(title: String, onClick: () -> Unit = {}) {
    val onback = LocalFlowBack.current

    BackHandler {
        onback()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Top App Bar $title") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable{onback()}
                    )
                }

            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title)
            Button(onClick = {
                onClick()
            }) {
                Text("Button $title")
            }

        }
    }
}