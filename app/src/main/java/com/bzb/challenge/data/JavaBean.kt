package com.bzb.challenge.data

import androidx.annotation.DrawableRes

/**
 * @author bzb
 * @date 2021/3/3 17:08
 * @description
 */

data class DogInfo(
    val name: String,
    val desc: String,
    @DrawableRes val image: Int,
    val imgUrl: String? = null,
    val link: String? = null
)