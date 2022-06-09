package com.bzb.challenge.navigation

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
    var currentTab: TabPage = TabPage.HomePage
        private set



    /**
     * 导航到 xx Tab下
     */
    fun navigationTo(tabPage: TabPage) {
        currentTab = tabPage
    }

    /**
     * 返回到首页tab
     */
    fun backToHome(): Boolean {
        val isHome = currentTab == TabPage.HomePage
        currentTab = TabPage.HomePage
        return isHome
    }

}