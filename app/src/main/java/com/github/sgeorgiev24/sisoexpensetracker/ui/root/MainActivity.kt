package com.github.sgeorgiev24.sisoexpensetracker.ui.root

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.fragment.app.FragmentActivity
import com.github.sgeorgiev24.sisoexpensetracker.presentation.navigation.NavigationDispatcher
import com.github.sgeorgiev24.sisoexpensetracker.ui.theme.BlueGrotto
import com.github.sgeorgiev24.sisoexpensetracker.ui.theme.SisoExpenseTrackerTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @Inject
    lateinit var navigationDispatcher: NavigationDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SisoExpenseTrackerTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = BlueGrotto,
                        darkIcons = false
                    )
                }
                AppRouter(navigationDispatcher)
            }
        }
    }
}