@file:OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterialApi::class)

package com.github.sgeorgiev24.sisoexpensetracker.ui.root

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.SwipeableDefaults
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.plusAssign
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationCommand
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationDispatcher
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.destinations.AuthDestination
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.destinations.MainDestination
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.wrapper.composableHolder
import com.github.sgeorgiev24.sisoexpensetracker.ui.home.MainScreen
import com.github.sgeorgiev24.sisoexpensetracker.ui.splash.SplashScreen
import com.github.sgeorgiev24.sisoexpensetracker.ui.theme.SisoExpenseTrackerTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppRouter(
    navigationDispatcher: NavigationDispatcher
) {
    val navController = rememberAnimatedNavController()
    val bottomSheetNavigator = rememberFullScreenBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator

    LaunchedEffect(Unit) {
        navigationDispatcher.navigationCommands.collectLatest { navigationCommand ->
            when (navigationCommand) {
                NavigationCommand.Back -> navController.popBackStack()
                is NavigationCommand.PopToDestination -> {
                    navController.popBackStack(
                        route = navigationCommand.navAction.route,
                        inclusive = navigationCommand.inclusive
                    )
                }
                is NavigationCommand.Navigate -> {
                    navController.navigate(
                        route = navigationCommand.navAction.route,
                        navOptions = navigationCommand.navAction.navOptions,
                    )
                }
            }
        }
    }

    ProvideWindowInsets {
        SisoExpenseTrackerTheme {
            ModalBottomSheetLayout(
                sheetShape = RoundedCornerShape(16.dp),
                bottomSheetNavigator = bottomSheetNavigator
            ) {
                AnimatedNavHost(
                    navController = navController,
                    startDestination = AuthDestination.Splash.route
                ) {
                    authDestinations()
                    mainDestinations()
                }
            }
        }
    }
}

private fun NavGraphBuilder.mainDestinations() {
    composableHolder(MainDestination.Main) {
        MainScreen()
    }
}

private fun NavGraphBuilder.authDestinations() {
    composableHolder(AuthDestination.Splash) {
        SplashScreen()
    }
}

@Composable
fun rememberFullScreenBottomSheetNavigator(
    animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec,
    skipHalfExpanded: Boolean = true,
): BottomSheetNavigator {
    val sheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        animationSpec
    )

    if (skipHalfExpanded) {
        LaunchedEffect(sheetState) {
            snapshotFlow { sheetState.isAnimationRunning }
                .collect {
                    with(sheetState) {
                        val isOpening =
                            currentValue == ModalBottomSheetValue.Hidden && targetValue == ModalBottomSheetValue.HalfExpanded
                        val isClosing =
                            currentValue == ModalBottomSheetValue.Expanded && targetValue == ModalBottomSheetValue.HalfExpanded
                        when {
                            isOpening -> animateTo(ModalBottomSheetValue.Expanded)
                            isClosing -> animateTo(ModalBottomSheetValue.Hidden)
                        }
                    }
                }
        }
    }

    return remember(sheetState) {
        BottomSheetNavigator(sheetState = sheetState)
    }
}