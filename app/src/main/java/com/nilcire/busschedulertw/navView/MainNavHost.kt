package com.nilcire.busschedulertw.navView

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nilcire.busschedulertw.ComposeViewModel
import com.nilcire.busschedulertw.MainActivity
import com.nilcire.busschedulertw.R
import com.nilcire.busschedulertw.Screen
import com.nilcire.busschedulertw.modules.home.HomePage
import com.nilcire.busschedulertw.modules.home.HomePageViewModel
import com.nilcire.busschedulertw.modules.search.SearchBusPage
import com.nilcire.busschedulertw.modules.search.SearchBusViewModel
import com.nilcire.busschedulertw.modules.search.SearchPage
import com.nilcire.busschedulertw.modules.search.SearchPageViewModel

@ExperimentalFoundationApi
@ExperimentalPagerApi
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
        composable(Transportations.Bus.name) {
            viewModel = handleViewModelLifeCycle(viewModel, SearchBusViewModel::class.java)
            MainActivity.state.currentPage = Screen.SearchPage
            SearchBusPage(navController, viewModel as SearchBusViewModel) }
    }
}

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

sealed class Transportations(val name: String, @DrawableRes val iconRes: Int) {
    object Bus: Transportations("Bus", R.drawable.ic_directions_bus_filled_black_24dp)
    object Train: Transportations("Train", R.drawable.ic_train_black_24dp)
    object MRT: Transportations("MRT", R.drawable.ic_subway_black_24dp)
    object TRS: Transportations("TRS", R.drawable.ic_directions_railway_filled_black_24dp)
    object Flights: Transportations("Flights", R.drawable.ic_flight_takeoff_black_24dp)
}