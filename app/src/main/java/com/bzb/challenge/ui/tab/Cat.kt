package com.bzb.challenge.ui.tab

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.bzb.challenge.util.toast

/**
 * @author bzb
 * @date 2022/6/9 13:40
 * @description
 */


@Composable
fun CatPage() {
    Box {
        val context = LocalContext.current
        Button(onClick = {
            "汪汪汪".toast(context)
        }) {
            Text(text = "喵喵喵", color = MaterialTheme.colors.primary)
        }
    }
}