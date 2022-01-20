package com.nilcire.busschedulertw.mainView

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavHostController
import com.nilcire.busschedulertw.ComposeViewModel
import com.nilcire.busschedulertw.MainActivity
import com.nilcire.busschedulertw.navView.MainButtonNavBar
import com.nilcire.busschedulertw.navView.items
import com.nilcire.busschedulertw.utilView.MainToolBar

@Composable
fun SearchPage(navController: NavHostController, viewModel: SearchPageViewModel) {

//    val viewModel: SearchPageViewModel by lazy { ComposeViewModel.Factory.create(SearchPageViewModel::class.java) }


    Scaffold(
        topBar = { MainToolBar(name = "SearchPage", true) },
        content = { Text(text = "SearchPage") },
        bottomBar = { MainButtonNavBar(navController, items) }
    )

//    DisposableEffect(key1 = MainActivity.state) {
//        viewModel.onStart()
//        onDispose {
//            viewModel.onStop()
//        }
//    }
}