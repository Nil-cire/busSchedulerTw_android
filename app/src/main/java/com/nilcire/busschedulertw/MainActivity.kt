package com.nilcire.busschedulertw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nilcire.busschedulertw.navView.MainNavHost
import com.nilcire.busschedulertw.ui.theme.BusSchedulerTwTheme
import com.google.accompanist.pager.ExperimentalPagerApi


class MainActivity : ComponentActivity() {

    object state {
        var currentPage: Screen = Screen.HomePage
    }
    lateinit var navController: NavHostController;

    @ExperimentalFoundationApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        var mainActivityViewModel = ViewModelProvider(this).get(SearchPageViewModel::class.java)

        setContent {
            BusSchedulerTwTheme {
                navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
                    MainActivityBaseView("WekWek", navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}



@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun MainActivityBaseView(title: String, navController: NavHostController) {

    MainNavHost(navController)

}



@ExperimentalFoundationApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    BusSchedulerTwTheme {
        MainActivityBaseView("title", rememberNavController())
    }
}

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object HomePage : Screen("homePage", R.string.homePage)
    object SearchPage : Screen("searchPage", R.string.searchPage)
    object AlarmPage : Screen("alarmPage", R.string.searchPage)
}