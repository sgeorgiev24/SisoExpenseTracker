package com.github.sgeorgiev24.sisoexpensetracker.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.sgeorgiev24.sisoexpensetracker.data.repository.AuthRepository
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationDispatcher
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.destinations.MainDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val navigationDispatcher: NavigationDispatcher
) : ViewModel() {

    fun validateAuthState() {
        viewModelScope.launch {
            if (authRepository.isAuthenticated()) {
                navigateToHome()
            } else {
                // navigate to login
            }
        }
    }

    private fun navigateToHome() {
        viewModelScope.launch {
            navigationDispatcher.navigateTo(MainDestination.Main)
        }
    }
}