package com.github.sgeorgiev24.sisoexpensetracker.ui.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.destinations.MainDestination
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.wrapper.composableHolder
import com.github.sgeorgiev24.sisoexpensetracker.ui.analytics.AnalyticsScreen
import com.github.sgeorgiev24.sisoexpensetracker.ui.component.bottombar.BottomNavigationItem
import com.github.sgeorgiev24.sisoexpensetracker.ui.component.bottombar.SETBottomBar
import com.github.sgeorgiev24.sisoexpensetracker.ui.settings.SettingsScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()

    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Analytics,
        BottomNavigationItem.Settings
    )

    Scaffold(
        bottomBar = {
            SETBottomBar(
                items = items,
                defaultItem = BottomNavigationItem.Home,
                navController = navController
            )
        }
    ) {
        AnimatedNavHost(
            navController = navController,
            startDestination = MainDestination.MainGraph.route
        ) {
            mainDestinations()
        }
    }
}

private fun NavGraphBuilder.mainDestinations() {
    navigation(
        startDestination = MainDestination.Home.route,
        route = MainDestination.MainGraph.route
    ) {
        composableHolder(MainDestination.Home) {
            HomeScreen()
        }
        composableHolder(MainDestination.Analytics) {
            AnalyticsScreen()
        }
        composableHolder(MainDestination.Settings) {
            SettingsScreen()
        }
    }
}