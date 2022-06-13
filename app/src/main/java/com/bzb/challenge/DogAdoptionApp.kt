package com.bzb.challenge

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bzb.challenge.navigation.DogBottomTabView
import com.bzb.challenge.navigation.DogBottomTabInfo
import com.bzb.challenge.navigation.NavigationViewModel
import com.bzb.challenge.navigation.TabPage
import com.bzb.challenge.theme.DogAdoptionTheme
import com.bzb.challenge.ui.common.ActionView
import com.bzb.challenge.ui.common.AppBarView
import com.bzb.challenge.ui.common.CircleHeadView
import com.bzb.challenge.ui.common.TitleView
import com.bzb.challenge.ui.slide.SlidePageView
import com.bzb.challenge.ui.tab.CatPage
import com.bzb.challenge.ui.tab.HomePage
import kotlinx.coroutines.launch

/**
 * @author bzb
 * @date 2021/3/2 10:34
 * @description Application
 */

/**
 * 底部导航栏
 */
val mTabList: List<DogBottomTabInfo> by lazy {
    mutableListOf<DogBottomTabInfo>().apply {
        add(DogBottomTabInfo("Dog", R.drawable.ic_tab_dog, R.drawable.ic_tab_dog_s, TabPage.HomePage))
        add(DogBottomTabInfo("Cat", R.drawable.ic_tab_cat, R.drawable.ic_tab_cat_s, TabPage.CatPage))
    }
}

@Composable
fun DogAdoptionApp(navigationViewModel: NavigationViewModel) {
    DogAdoptionTheme(false) {
        AppContent(navigationViewModel)
    }
}

@Composable
fun AppContent(navigationViewModel: NavigationViewModel) {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(DrawerValue.Closed)
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBarView(
                title = { TitleView() },
                icon = {
                    CircleHeadView(40.dp) {
                        coroutineScope.launch { scaffoldState.drawerState.open() }
                    }
                },
                action = { ActionView() }
            )
        },
        drawerBackgroundColor = Color.Transparent,
        drawerContent = {
            SlidePageView(scaffoldState)
        },

        bottomBar =  {
            DogBottomTabView(navigationViewModel, mTabList)
        }
    ) {
        Crossfade(navigationViewModel.getCurrentTab()) {
            Surface {
                Column {
                    when (it) {
                        is TabPage.HomePage -> {
                            HomePage()
                        }
                        is TabPage.CatPage -> {
                            CatPage()
                        }
                    }
                }
            }
        }
    }
}
