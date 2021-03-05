package com.bzb.challenge.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.bzb.challenge.R

/**
 * @author bzb
 * @date 2021/3/5 11:04
 * @description 测试
 */
class TestFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // 1.xml 填充 Android和Compose View
        /*return inflater.inflate(R.layout.layout_android_of_compose, container).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {
                MaterialTheme {
                    Text("Hello Compose!")
                }
            }
        }*/

        // 2.new layout 填充 Android和Compose View
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL

            addView(TextView(context).apply {
                text = "Hello Android!"
            })

            addView(ComposeView(context).apply {
                id = R.id.compose_view_x
                setContent {
                    MaterialTheme {
                        Text("Hello Compose!")
                    }
                }
            })
        }
    }

}