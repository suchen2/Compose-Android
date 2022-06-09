package com.bzb.challenge.navigation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * @author bzb
 * @date 2021/3/2 10:28
 * @description 首页导航vm
 */

class NavigationViewModel: ViewModel(){

    /**
     * 首页tab
     */
    private var currentTab = mutableStateOf<TabPage>(TabPage.HomePage)
    fun getCurrentTab(): TabPage = currentTab.value


    /**
     * 导航到 xx Tab下
     */
    fun navigationTo(tabPage: TabPage) {
        currentTab.value = tabPage
    }

    /**
     * 返回到首页tab
     * @return 返回后是否已经到达首页
     */
    fun backToHome(): Boolean {
        val isHome = currentTab.value == TabPage.HomePage
        currentTab.value = TabPage.HomePage
        return isHome
    }

}