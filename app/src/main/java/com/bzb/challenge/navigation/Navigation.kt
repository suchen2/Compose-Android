package com.bzb.challenge.navigation

/**
 * @author bzb
 * @date 2021/3/2 10:39
 * @description App导航
 */

enum class TabName {
    PAGE_HOME, PAGE_CAT
}

sealed class TabPage(tabName: TabName) {
    object CatPage: TabPage(TabName.PAGE_CAT)
    object HomePage: TabPage(TabName.PAGE_HOME)
}