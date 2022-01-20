package com.nilcire.busschedulertw.modules.search

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.nilcire.busschedulertw.R
import com.nilcire.busschedulertw.Screen
import com.nilcire.busschedulertw.navView.MainButtonNavBar
import com.nilcire.busschedulertw.navView.Transportations
import com.nilcire.busschedulertw.navView.items
import com.nilcire.busschedulertw.utilView.MainToolBar

@ExperimentalFoundationApi
@Composable
fun SearchPage(navController: NavHostController, viewModel: SearchPageViewModel) {

//    val viewModel: SearchPageViewModel by lazy { ComposeViewModel.Factory.create(SearchPageViewModel::class.java) }


    Scaffold(
        topBar = { MainToolBar(name = "SearchPage", false) },
        content = { SearchItemsView(navController) },
        bottomBar = { MainButtonNavBar(navController, items) }
    )

//    DisposableEffect(key1 = MainActivity.state) {
//        viewModel.onStart()
//        onDispose {
//            viewModel.onStop()
//        }
//    }
}

//val supportSearchItems: Map<String, List<SearchPageItem>> =
//    mapOf(
//        "aaa" to listOf(
//            SearchPageItem("Bus"),
//            SearchPageItem("Train"),
//            SearchPageItem("MRT"),
//            SearchPageItem("TRS"),
//        )
//



val supportTransportations: List<SearchPageItem> =
    listOf(
        SearchPageItem(0, Transportations.Bus.name, Transportations.Bus.iconRes),
        SearchPageItem(1, Transportations.Train.name, Transportations.Train.iconRes),
        SearchPageItem(2, Transportations.MRT.name, Transportations.MRT.iconRes),
        SearchPageItem(3, Transportations.TRS.name, Transportations.TRS.iconRes),
        SearchPageItem(4, Transportations.Flights.name, Transportations.Flights.iconRes),
    )

@ExperimentalFoundationApi
@Composable
fun SearchItemsView(navController: NavHostController) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        cells = GridCells.Fixed(2),
//        cells = GridCells.Adaptive(400.dp),
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 8.dp,
            end = 16.dp,
            bottom = 8.dp
        ),
        content = {
            items(supportTransportations.size) { index ->
                Surface(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navigateSearchPageDetail(navController, supportTransportations[index].itemName) },
                ) {
                    Column(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .aspectRatio(1.0f)
//                            .clip(RoundedCornerShape(16.dp))
//                            .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                        ,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painterResource(supportTransportations[index].imgRes),
                            "",
                            modifier = Modifier.width(64.dp).height(64.dp)
                        )
                        Text(
                            text = supportTransportations[index].itemName,
                            modifier = Modifier.fillParentMaxWidth().height(20.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}

fun navigateSearchPageDetail(navController: NavHostController, destination: String) {
    when (destination) {
        Transportations.Bus.name -> {
            navController.navigate(Transportations.Bus.name) {
                popUpTo(Screen.SearchPage.route)
            }
        }
    }
}