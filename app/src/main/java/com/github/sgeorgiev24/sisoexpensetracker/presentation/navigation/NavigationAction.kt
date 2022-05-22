package com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavOptions

typealias enterAnim =
    (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?)?

typealias exitAnim =
    (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?)?

interface NavigationAction {
    val route: String
    val navOptions: NavOptions
        get() = NavOptions.Builder().build()
    val arguments: List<NamedNavArgument>
        get() = emptyList()
    val enterTransition: enterAnim
        get() = null
    val exitTransition: exitAnim
        get() = null
    val popEnterTransition: enterAnim
        get() = null
    val popExitTransition: exitAnim
        get() = null
}