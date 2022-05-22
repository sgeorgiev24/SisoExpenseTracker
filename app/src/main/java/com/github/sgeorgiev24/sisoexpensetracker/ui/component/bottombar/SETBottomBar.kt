package com.github.sgeorgiev24.sisoexpensetracker.ui.component.bottombar

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.github.sgeorgiev24.sisoexpensetracker.ui.theme.*
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun SETBottomBar(
    items: Iterable<BottomNavigationItem>,
    defaultItem: BottomNavigationItem,
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier
            .navigationBarsHeight(additional = 80.dp),
        elevation = 0.dp,
    ) {
        items.forEach { navItem ->
            val selected = currentDestination?.route == navItem.destination.route
            BottomNavigationItem(
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(bottom = 8.dp),
                icon = {
                    Icon(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .height(height = 25.dp),
                        painter = painterResource(navItem.iconId),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        stringResource(navItem.labelId),
                        color = if (selected) SilverPink else NavyBlue,
                        style = bottomBarTextStyle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(navItem.destination.route) {
                        popUpTo(defaultItem.destination.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

//@Composable
//fun resolveBottomNavBarColor(currentDestination: NavDestination?): State<Color> {
//    return animateColorAsState(
//        if (currentDestination?.route == MainDestination.Events.route) Charcoal
//        else Color.Transparent,
//        animationSpec = tween(500)
//    )
//}