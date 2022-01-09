package com.nilcire.busschedulertw.navView

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nilcire.busschedulertw.MainActivity
import com.nilcire.busschedulertw.Screen
import com.nilcire.busschedulertw.mainView.HomePage
import com.nilcire.busschedulertw.mainView.HomePageViewModel
import com.nilcire.busschedulertw.mainView.SearchPage

@Composable
fun MainNavHost(navController: NavHostController) {

//    val viewModel: HomePageViewModel = HomePageViewModel()

    NavHost(navController = navController, startDestination = Screen.HomePage.route) {
        composable(Screen.HomePage.route) {
            MainActivity.state.currentPage = Screen.HomePage
            HomePage(navController) }
        composable(Screen.SearchPage.route) {
            MainActivity.state.currentPage = Screen.SearchPage
            SearchPage(navController) }
    }
}

val items = listOf(
    Screen.HomePage,
    Screen.SearchPage,
    Screen.AlarmPage,
)