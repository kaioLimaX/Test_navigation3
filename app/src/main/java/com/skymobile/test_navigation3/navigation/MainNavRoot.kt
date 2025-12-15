package com.skymobile.test_navigation3.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation3.ui.NavDisplay
import com.skymobile.test_navigation3.R
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.qualifier.named

@OptIn(KoinExperimentalAPI::class)
@Composable
fun MainNavRoot() {
    val bottomBarItems = mutableListOf(
        BottomBarItem("Home", painterResource(R.drawable.ic_home), MainDestination.Home),
        BottomBarItem("Profile", painterResource(R.drawable.ic_profile), MainDestination.Profile),
        BottomBarItem("Settings", painterResource(R.drawable.ic_settings), MainDestination.Settings),
    )
    val entryProvider = koinEntryProvider()
    val navigator = koinInject<Navigator>(named("Main"))

    var selectedItem by remember { mutableStateOf(bottomBarItems.first()) }



    Scaffold(
        contentWindowInsets = WindowInsets(),
        bottomBar = {
            MainBottomBar(
                items = bottomBarItems,
                selectedItem = selectedItem,
                onItemSelected = {
                    selectedItem = it
                    navigator.navigateTo(it.destination)
                }
            )
        }
    ) { paddingValues ->
        // Screen content
        NavDisplay(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            backStack = navigator.backstack,
            onBack = { navigator.goBack() },
            entryProvider = entryProvider
        )
    }
}

@Stable
data class BottomBarItem(
    val label: String,
    val icon: Painter,
    val destination: MainDestination
)

@Composable
private fun MainBottomBar(
    items: MutableList<BottomBarItem>,
    selectedItem: BottomBarItem,
    onItemSelected: (selected: BottomBarItem) -> Unit
) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label
                    )
                },
                selected = selectedItem == item,
                onClick = { onItemSelected(item) }
            )
        }
    }
}