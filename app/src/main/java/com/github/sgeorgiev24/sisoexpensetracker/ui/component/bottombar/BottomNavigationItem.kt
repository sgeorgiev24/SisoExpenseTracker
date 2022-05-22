package com.github.sgeorgiev24.sisoexpensetracker.ui.component.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.github.sgeorgiev24.sisoexpensetracker.R
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationAction
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.destinations.MainDestination

sealed class BottomNavigationItem(
    val destination: NavigationAction,
    @StringRes val labelId: Int,
    @DrawableRes val iconId: Int
) {
    object Home : BottomNavigationItem(
        MainDestination.Home,
        R.string.bottom_bar_home,
        R.drawable.ic_home
    )

    object Analytics : BottomNavigationItem(
        MainDestination.Analytics,
        R.string.bottom_bar_analytics,
        R.drawable.ic_analytics
    )

    object Settings : BottomNavigationItem(
        MainDestination.Settings,
        R.string.bottom_bar_settings,
        R.drawable.ic_settings
    )
}