package com.bzb.challenge.ui.slide

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.bzb.challenge.ui.common.CircleHeadView
import kotlinx.coroutines.launch

/**
 * @author bzb
 * @date 2021/3/1 16:18
 * @description 侧滑页
 */

@Composable
fun slidePageView(scaffoldState: ScaffoldState) {
    val coroutineScope = rememberCoroutineScope()

    Column {
        slideHeadView {
            coroutineScope.launch { scaffoldState.drawerState.close() }
        }

        slideBodyView()

        slideFootView()
    }
}