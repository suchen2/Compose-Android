package com.bzb.challenge

/**
 * @author bzb
 * @date 2021/3/2 10:39
 * @description App导航
 */

enum class TabName {
    PAGE_HOME
}

sealed class TabPage(tabName: TabName) {
    object HomePage: TabPage(TabName.PAGE_HOME)
}