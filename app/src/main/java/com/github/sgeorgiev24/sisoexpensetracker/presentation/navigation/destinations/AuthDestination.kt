package com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.destinations

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationAction
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.enterAnim
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.exitAnim

sealed class AuthDestination : NavigationAction {

    object Splash : AuthDestination() {
        override val route: String
            get() = "splash"
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