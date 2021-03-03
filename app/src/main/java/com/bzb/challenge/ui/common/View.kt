package com.bzb.challenge.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bzb.challenge.R
import com.bzb.challenge.theme.textWhite
import com.bzb.challenge.util.toast

/**
 * @author bzb
 * @date 2021/3/1 16:18
 * @description 公共View
 */


@Composable
fun AppBarView(
    modifier: Modifier = Modifier,
    title: @Composable() () -> Unit,
    icon: @Composable() (() -> Unit)? = null,
    action: @Composable() (RowScope.() -> Unit) = {},
) {
    TopAppBar(
        title = title,
        actions = action,
        modifier = modifier,
        navigationIcon = icon
//            contentColor = MaterialTheme.colors.onSurface,
    )

}


/**
 * 搜索
 * searchView(search_home, Modifier.align(Alignment.CenterVertically))
 */
@Composable
fun searchView(hint: String, modifier: Modifier = Modifier, corner: Dp = 28.dp) {

    var textState by remember { mutableStateOf(TextFieldValue()) }
    val colors = TextFieldDefaults.textFieldColors()
    colors.cursorColor(isError = false) // LocalContentColor.current

    TextField(
        value = textState,
        maxLines = 1,
        colors = colors,
        textStyle = LocalTextStyle.current.copy(color = LocalContentColor.current),
        placeholder = {
            Text(
                hint,
                color = MaterialTheme.colors.onSurface.copy(ContentAlpha.disabled)
            )
        },
        onValueChange = {
            textState = it
        }
    )
}


@Composable
fun ActionView() {
    val context = LocalContext.current
    Text(
        text = "Action",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(end = 10.dp)
            .clickable {
                "click".toast(context)
            },
    )
}


@Composable
fun CircleHeadView(size: Dp, click: () -> Unit) {
    Image(
        contentScale = ContentScale.Crop,
        painter = painterResource(R.drawable.samo),
        contentDescription = stringResource(R.string.action_slide),
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .clickable {
                click()
            }
    )
}

@Composable
fun TitleView() {
    val appName = LocalContext.current.applicationInfo.name ?: "DogAdoption"
    Box {
        Text(
            text = appName,
            color = contentColorFor(textWhite),
            style = MaterialTheme.typography.h5,
        )
    }
}
