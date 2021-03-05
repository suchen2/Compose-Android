package com.bzb.challenge

import androidx.compose.animation.Crossfade
import androidx.compose.material.DrawerValue
import androidx.compose.material.Surface
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import com.bzb.challenge.theme.DogAdoptionTheme
import com.bzb.challenge.ui.tab.HomePage

/**
 * @author bzb
 * @date 2021/3/2 10:34
 * @description Application
 */

@Composable
fun DogAdoptionApp(navigationViewModel: NavigationViewModel) {
    DogAdoptionTheme(false) {
        AppContent(navigationViewModel)
    }
}

@Composable
fun AppContent(navigationViewModel: NavigationViewModel) {
    Crossfade(navigationViewModel.currentTab) {
        Surface {
            when (it) {
                is TabPage.HomePage -> {
                    val scaffoldState = rememberScaffoldState(
                        drawerState = rememberDrawerState(DrawerValue.Closed)
                    )
                    HomePage(scaffoldState)
                }
            }
        }
    }
}
