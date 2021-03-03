package com.bzb.challenge.util

import android.content.Context
import android.widget.Toast

/**
 * @author bzb
 * @date 2021/3/3 16:54
 * @description 公共的
 */


fun String.toast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}
