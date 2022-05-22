package com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation

sealed class NavigationCommand {
    data class Navigate(val navAction: NavigationAction) : NavigationCommand()
    data class PopToDestination(
        val navAction: NavigationAction,
        val inclusive: Boolean
    ) : NavigationCommand()

    object Back : NavigationCommand()
}
