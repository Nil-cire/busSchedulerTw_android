package com.nilcire.busschedulertw.utilView

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun MainToolBar(name: String) {
    TopAppBar(
        title = { Text(text = name) },
    )
}