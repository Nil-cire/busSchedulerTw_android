package com.nilcire.busschedulertw.navView

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nilcire.busschedulertw.ComposeViewModel
import com.nilcire.busschedulertw.MainActivity
import com.nilcire.busschedulertw.Screen
import com.nilcire.busschedulertw.mainView.HomePage
import com.nilcire.busschedulertw.mainView.HomePageViewModel
import com.nilcire.busschedulertw.mainView.SearchPage
import com.nilcire.busschedulertw.mainView.SearchPageViewModel

@Composable
fun MainNavHost(navController: NavHostController) {

    var viewModel: ComposeViewModel = HomePageViewModel()

    NavHost(navController = navController, startDestination = Screen.HomePage.route) {
        composable(Screen.HomePage.route) {
            viewModel = handleViewModelLifeCycle(viewModel, HomePageViewModel::class.java)
            MainActivity.state.currentPage = Screen.HomePage
            HomePage(navController, viewModel as HomePageViewModel) }
        composable(Screen.SearchPage.route) {
            viewModel = handleViewModelLifeCycle(viewModel, SearchPageViewModel::class.java)
            MainActivity.state.currentPage = Screen.SearchPage
            SearchPage(navController, viewModel as SearchPageViewModel) }
    }
}

@Composable
private fun <T: ComposeViewModel> handleViewModelLifeCycle(viewModel: ComposeViewModel, viewModelClass: Class<T>): ComposeViewModel {
    var newViewModel = viewModel
    if (viewModel.javaClass != viewModelClass) {
        viewModel.onStop()
        newViewModel = ComposeViewModel.Factory.create(viewModelClass)
        newViewModel.onStart()
    }
    return newViewModel
}

val items = listOf(
    Screen.HomePage,
    Screen.SearchPage,
    Screen.AlarmPage,
)