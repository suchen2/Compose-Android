package com.bzb.challenge.ui.tab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bzb.challenge.data.DogInfo
import com.bzb.challenge.ui.common.AppBarView
import com.bzb.challenge.ui.common.ActionView
import com.bzb.challenge.ui.common.CircleHeadView
import com.bzb.challenge.ui.common.TitleView
import com.bzb.challenge.ui.slide.slidePageView
import kotlinx.coroutines.launch

/**
 * @author bzb
 * @date 2021/3/1 17:08
 * @description 首页tab
 */

@Composable
fun HomePage(scaffoldState: ScaffoldState) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBarView(
                title = { TitleView() },
                icon = { CircleHeadView(40.dp) {
                    coroutineScope.launch { scaffoldState.drawerState.open() }
                } },
                action = { ActionView() }
            )
        },
        drawerContent = {
            slidePageView(scaffoldState)
        },
    ) {

        val listData = mutableStateListOf<DogInfo>()

        recommendListView(listData)
    }
}




// https://developer.android.com/jetpack/compose/lists
@Composable
fun recommendListView(listData: List<DogInfo>) {
    val padding = PaddingValues(2.dp)
    LazyColumn(contentPadding = padding) {
        items(listData) { info ->
            Box(Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(info.image),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(130.dp, 170.dp)
                )

                Text(
                    text = info.name,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )

                Text(
                    text = info.desc,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotoGrid(listData: List<DogInfo>) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(listData) { info ->
            Image(painterResource(info.image), "item")
        }
    }
}

