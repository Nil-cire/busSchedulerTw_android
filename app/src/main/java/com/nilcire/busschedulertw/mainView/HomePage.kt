package com.nilcire.busschedulertw.mainView

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.nilcire.busschedulertw.ComposeViewModel
import com.nilcire.busschedulertw.MainActivity
import com.nilcire.busschedulertw.navView.MainButtonNavBar
import com.nilcire.busschedulertw.navView.items
import com.nilcire.busschedulertw.utilView.MainToolBar

@Composable
fun HomePage(navController: NavHostController) {

    val viewModel: HomePageViewModel by lazy { ComposeViewModel.Factory.create(HomePageViewModel::class.java) }
//    val viewModel: HomePageViewModel = ComposeViewModel.Factory.create(HomePageViewModel::class.java)

    Scaffold(
        topBar = { MainToolBar(name = "HomePage") },
        content = { Text(text = "HomePage") },
        bottomBar = { MainButtonNavBar(navController, items) }
    )

    DisposableEffect(key1 = MainActivity.state) {
        viewModel.onStart()
        onDispose {
            viewModel.onStop()
        }
    }


}

@Preview(showBackground = true)
@Composable
fun Preview() {
//    HomePage(NavHostController())
}