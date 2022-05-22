package com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation

import kotlinx.coroutines.flow.*

class NavigationManagerImpl : NavigationManager {

    private val _navActions = MutableSharedFlow<NavigationCommand>()
    override val navActions = _navActions.asSharedFlow()

    override suspend fun navigate(command: NavigationCommand) {
        _navActions.emit(command)
    }
}