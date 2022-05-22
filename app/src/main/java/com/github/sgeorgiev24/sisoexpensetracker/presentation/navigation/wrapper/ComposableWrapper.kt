package com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.wrapper

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationAction
import com.google.accompanist.navigation.animation.composable

fun NavGraphBuilder.composableHolder(
    action: NavigationAction,
    content: @Composable () -> Unit
) {
    composable(
        route = action.route,
        arguments = action.arguments,
        enterTransition = action.enterTransition,
        exitTransition = action.exitTransition,
        popEnterTransition = action.popEnterTransition,
        popExitTransition = action.popExitTransition
    ) {
        content()
    }
}

fun NavGraphBuilder.composableHolderWithArgs(
    action: NavigationAction,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = action.route,
        arguments = action.arguments,
        enterTransition = action.enterTransition,
        exitTransition = action.exitTransition,
        popEnterTransition = action.popEnterTransition,
        popExitTransition = action.popExitTransition
    ) { navBackStack ->
        content(navBackStack)
    }
}