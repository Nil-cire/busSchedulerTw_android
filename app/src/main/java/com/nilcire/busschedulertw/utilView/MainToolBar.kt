package com.nilcire.busschedulertw.utilView

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MainToolBar(name: String, haveBackStack: Boolean) {

    val backIconWidth: Dp = 24.dp
    val topAppBarPadding: Dp = 16.dp

    if (haveBackStack) {
        TopAppBar(modifier = Modifier
            .fillMaxWidth()) {
            Spacer(modifier = Modifier.width(topAppBarPadding))
            IconButton(onClick = {}, modifier = Modifier.width(backIconWidth)) {
                Icon(Icons.Filled.ArrowBack, "Back")
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(end = backIconWidth + topAppBarPadding),
                contentAlignment = Alignment.Center) {
                Text(text = name, textAlign = TextAlign.Center)
            }
//            Spacer(modifier = Modifier.width(topAppBarPadding + backIconWidth))

        }
    } else {
        TopAppBar(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = name, textAlign = TextAlign.Center)
            }
        }
    }


//    if (haveBackStack) {
//        TopAppBar(
//            title = { Text(text = name) },
//            navigationIcon = { Icon(Icons.Filled.ArrowBack, "back") }
//        )
//    } else {
//        TopAppBar(
//            title = {
//                Text(
//                text = name,
//                modifier = Modifier.) },
//        )
//    }


}