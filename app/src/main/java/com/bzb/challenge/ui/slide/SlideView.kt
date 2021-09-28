package com.bzb.challenge.ui.slide

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bzb.challenge.ui.common.CircleHeadView

/**
 * @author bzb
 * @date 2021/3/1 16:36
 * @description 侧滑页头部
 */

@Composable
fun SlideHeadView(click: () -> Unit) {
    Row(Modifier.padding(top = 25.dp)) {
        CircleHeadView(65.dp, Modifier.padding(start = 20.dp), click)
        Text("Kotlin", Modifier.align(Alignment.CenterVertically).padding(start = 10.dp), fontSize = 22.sp, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun SlideBodyView() {
    Column{
        Text("Profile")

        Text("Second")
    }
}

@Composable
fun SlideFootView() {

}