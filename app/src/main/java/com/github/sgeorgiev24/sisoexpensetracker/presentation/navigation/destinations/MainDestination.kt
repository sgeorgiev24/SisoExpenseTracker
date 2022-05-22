package com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.destinations

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavOptions
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationAction
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.enterAnim
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.exitAnim

sealed class MainDestination : NavigationAction {
    object Main : MainDestination() {
        override val route: String
            get() = "main"
        override val navOptions: NavOptions
            get() = NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(0, true)
                .build()
        override val enterTransition: enterAnim
            get() = { fadeIn(tween(1000)) }
        override val exitTransition: exitAnim
            get() = { fadeOut(tween(1000)) }
        override val popEnterTransition: enterAnim
            get() = { fadeIn(tween(1000)) }
        override val popExitTransition: exitAnim
            get() = { fadeOut(tween(1000)) }
    }

    object MainGraph : MainDestination() {
        override val route: String
            get() = "homegraph"
    }

    object Home : MainDestination() {
        override val route: String
            get() = "home"
        override val enterTransition: enterAnim
            get() = { fadeIn(tween(1000)) }
        override val exitTransition: exitAnim
            get() = { fadeOut(tween(1000)) }
        override val popEnterTransition: enterAnim
            get() = { fadeIn(tween(1000)) }
        override val popExitTransition: exitAnim
            get() = { fadeOut(tween(1000)) }
    }

    object Analytics : MainDestination() {
        override val route: String
            get() = "analytics"
        override val enterTransition: enterAnim
            get() = { fadeIn(tween(1000)) }
        override val exitTransition: exitAnim
            get() = { fadeOut(tween(1000)) }
        override val popEnterTransition: enterAnim
            get() = { fadeIn(tween(1000)) }
        override val popExitTransition: exitAnim
            get() = { fadeOut(tween(1000)) }
    }

    object Settings : MainDestination() {
        override val route: String
            get() = "settings"
        override val enterTransition: enterAnim
            get() = { fadeIn(tween(1000)) }
        override val exitTransition: exitAnim
            get() = { fadeOut(tween(1000)) }
        override val popEnterTransition: enterAnim
            get() = { fadeIn(tween(1000)) }
        override val popExitTransition: exitAnim
            get() = { fadeOut(tween(1000)) }
    }
}
