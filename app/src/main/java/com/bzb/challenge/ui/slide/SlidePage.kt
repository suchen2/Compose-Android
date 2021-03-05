package com.bzb.challenge.ui.slide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bzb.challenge.theme.bg_slide_page
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

    Column(Modifier.fillMaxSize().background(bg_slide_page, RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))) {
        slideHeadView {
            coroutineScope.launch { scaffoldState.drawerState.close() }
        }

        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = .2f), modifier = Modifier.padding(top = 10.dp))

        slideBodyView()

        slideFootView()
    }
}