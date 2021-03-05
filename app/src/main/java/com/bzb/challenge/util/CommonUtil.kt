package com.bzb.challenge.util

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bzb.challenge.R

/**
 * @author bzb
 * @date 2021/3/3 16:54
 * @description 公共的
 */


fun String.toast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImg(url: String): ImageView {
    Glide.with(context).load(url).error(R.drawable.samo).into(this)
    return this
}

fun ImageView.loadImg(@DrawableRes resId: Int) {
    Glide.with(context).load(resId).error(R.drawable.samo).into(this)
}