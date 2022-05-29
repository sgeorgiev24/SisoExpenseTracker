package com.github.sgeorgiev24.sisoexpensetracker.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.sgeorgiev24.sisoexpensetracker.ui.theme.BabyBlue
import com.github.sgeorgiev24.sisoexpensetracker.ui.theme.NavyBlue
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    val viewModel: SplashViewModel = hiltViewModel()

    SplashScreenContent()

    LaunchedEffect(true) {
        delay(500)
        viewModel.validateAuthState()
    }
}

@Composable
private fun SplashScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            color = NavyBlue,
            textAlign = TextAlign.Center,
            text = "S E T",
            fontSize = 40.sp
        )
        Text(
            color = NavyBlue,
            textAlign = TextAlign.Center,
            text = "track your expenses",
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreenContent()
}