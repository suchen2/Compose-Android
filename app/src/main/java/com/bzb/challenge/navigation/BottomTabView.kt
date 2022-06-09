package com.bzb.challenge.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * Author: bzb
 * Data: 2021/9/29 17:00
 * Desc: 首页底部导航栏
 */

private val BottomNavigationHeight = 56.dp

/**
 * 底部导航栏view
 */
@Composable
fun DogBottomTabView(
    viewModel: NavigationViewModel,
    tabList: List<DogBottomTabInfo>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(BottomNavigationHeight)
            .selectableGroup()
            .background(Color.White)
    ) {

        val tabSize = tabList.size
        tabList.forEachIndexed { index, item ->
            item.selected.value = (viewModel.getCurrentTab() == item.tabPage)
            item.index = index

            DogItemView(item, tabSize) {
                // item点击
                if (item.tabPage != viewModel.getCurrentTab()) {
                    viewModel.navigationTo(it.tabPage)
                    tabList.forEachIndexed { index, info ->
                        info.selected.value = it.index == index
                    }
                }
            }

        }
    }
}


/**
 * 底部导航栏item
 */
@Composable
fun DogItemView(
    item: DogBottomTabInfo, tabSize: Int,
    click: (item: DogBottomTabInfo) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(1 / (tabSize.toFloat() - item.index))
            .clickable {
                click.invoke(item)
            }
    ) {
        val (img, text) = createRefs() // 或使用 createRef("text")
        Image(
            painter =
            painterResource(if (item.selected.value) item.pressIcon else item.normalIcon),
            contentDescription = item.title,
            modifier = Modifier.constrainAs(img) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(text.top)
            }
        )

        Text(
            text = item.title,
            color = if (item.selected.value) Color.Blue else Color.Gray,
            modifier = Modifier.constrainAs(text) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(img.bottom)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

/**
 * 底部导航栏item info
 */
data class DogBottomTabInfo(
    val title: String,
    @DrawableRes
    val normalIcon: Int,

    @DrawableRes
    val pressIcon: Int,
    var tabPage: TabPage,
    var selected: MutableState<Boolean> = mutableStateOf(false) ,
    var index: Int = -1,
)