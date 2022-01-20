package com.nilcire.busschedulertw.mainView.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.nilcire.busschedulertw.navView.MainButtonNavBar
import com.nilcire.busschedulertw.navView.items
import com.nilcire.busschedulertw.utilView.MainToolBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun HomePage(navController: NavHostController, viewModel: HomePageViewModel) {

//    val viewModel: HomePageViewModel by lazy { ComposeViewModel.Factory.create(HomePageViewModel::class.java) }
//    val viewModel: HomePageViewModel = ComposeViewModel.Factory.create(HomePageViewModel::class.java)

    val pagerState = remember { PagerState(2, 0) }
//    val pagerState = PagerState(2, 0)

    Scaffold(
        topBar = { MainToolBar(name = "HomePage", false) },
//        content = { Text(text = "HomePage") },
        content = { HomePageBody(viewModel, pagerState) },
        bottomBar = { MainButtonNavBar(navController, items) }
    )

    //    DisposableEffect(key1 = MainActivity.state) {
    //        viewModel.onStart()
    //        onDispose {
    //            viewModel.onStop()
    //        }
    //    }
}



data class PagerItem(val title: String, val iconRes: Int)

val pagerItems: List<PagerItem> = listOf(
    PagerItem("Search history", 0),
    PagerItem("Alarm sets", 1)
)

@ExperimentalPagerApi
@Composable
fun HomePageBody(viewModel: HomePageViewModel, pagerState: PagerState) {

    val number: State<Int> = viewModel.count.observeAsState(0)
//    val pageIndex: State<Int> = viewModel.count.observeAsState(0)
    val coroutineScope = rememberCoroutineScope()

//    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//        Text(text = "HomePage")
//        Button(onClick = { viewModel.addOne() }) {
//            Icon(Icons.Default.Share, "+1")
//        }
//        Text(text = "Current Count = ${number.value}")
//    }
    Column {
        HorizontalPager(
            state = pagerState,) {
            Text(text = pagerItems[pagerState.currentPage].title)
        }
        TabRow(selectedTabIndex = pagerState.currentPage) {
            pagerItems.forEachIndexed  { index, item ->
                Tab(selected = (index == pagerState.currentPage),
                    onClick = {
                        coroutineScope.launch(Dispatchers.Main) {
                                  pagerState.animateScrollToPage(index)
                              }
                    },
                    text = { Text(text = item.title)})
            }
        }
        when (pagerState.currentPage) {
            0 -> {
                SearchHistory(fakeDataList)
            }
            1 -> {
                AlarmHistory(alarmFakeDataList)
            }
        }
//        SearchHistory(fakeDataList)
//        HorizontalPager(state = pagerState) {
//            Text(text = pagerItems[pagerState.currentPage].title)
//        }
    }
}

val fakeDataList: List<SearchHistoryItem> =
    listOf(
        SearchHistoryItem("aaa",1),
        SearchHistoryItem("bbb",2),
        SearchHistoryItem("ccc",3),
        SearchHistoryItem("ddd",4),
        SearchHistoryItem("eee",5),
    )

val alarmFakeDataList: List<AlarmHistoryItem> =
    listOf(
        AlarmHistoryItem("111",1),
        AlarmHistoryItem("222",2),
        AlarmHistoryItem("333",3),
        AlarmHistoryItem("444",4),
        AlarmHistoryItem("555",5),
    )

data class SearchHistoryItem(var itemName: String, val id: Int)
data class AlarmHistoryItem(var itemName: String, val id: Int)

@Composable
fun SearchHistory(searchItems: List<SearchHistoryItem>) {
    LazyColumn {
        items(searchItems, key = {item -> item.id}) { item ->
            Text(text = item.itemName)
        }
    }
}

@Composable
fun AlarmHistory(searchItems: List<AlarmHistoryItem>) {
    LazyColumn {
        items(searchItems, key = {item -> item.id}) { item ->
            Text(text = item.itemName)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
//    HomePage(NavHostController())
}