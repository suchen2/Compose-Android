package com.bzb.challenge.ui.slide

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.bzb.challenge.ui.common.CircleHeadView

/**
 * @author bzb
 * @date 2021/3/1 16:36
 * @description 侧滑页头部
 */

@Composable
fun slideHeadView(click: @Composable () -> Unit) {
    CircleHeadView(60.dp) { click }
}


@Composable
fun slideBodyView() {

}

@Composable
fun slideFootView() {

}