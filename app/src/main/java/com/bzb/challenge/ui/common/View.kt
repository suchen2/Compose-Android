package com.bzb.challenge.ui.common

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bzb.challenge.R
import com.bzb.challenge.theme.textWhite
import com.bzb.challenge.util.toast
import kotlin.math.roundToInt

/**
 * @author bzb
 * @date 2021/3/1 16:18
 * @description 公共View
 */


@Composable
fun AppBarView(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    icon: @Composable (() -> Unit)? = null,
    action: @Composable (RowScope.() -> Unit) = {},
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
fun SearchView(hint: String, modifier: Modifier = Modifier, corner: Dp = 28.dp) {

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
fun CircleHeadView(size: Dp, modifier: Modifier = Modifier, click: () -> Unit) {
    Image(
        contentScale = ContentScale.Crop,
        painter = painterResource(R.drawable.samo),
        contentDescription = stringResource(R.string.action_slide),
        modifier = modifier
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

/**
 * test code
    FloatView(
     Modifier
     .align(Alignment.BottomEnd)
     .padding(end = 30.dp, bottom = 40.dp)
    )
 */
@Composable
fun FloatView(modifier: Modifier = Modifier) {
    val count = remember { mutableStateOf(0) }
    val offsetX by remember { mutableStateOf(0f) }
    val offsetY by remember { mutableStateOf(0f) }

    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    val state = rememberTransformableState { zoom, pan, rotationChange ->
        scale *= zoom
        rotation += rotationChange
        offset += pan
    }

    Box(
        modifier =
        modifier.size(150.dp).background(Color.Gray, RoundedCornerShape(3.dp))
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }

            // 缩放、旋转、平移
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                rotationZ = rotation,
                translationX = offset.x,
                translationY = offset.y
            ).transformable(state = state)

            /*.pointerInput(Unit) {
                // 点击
               *//* detectTapGestures(
                    onTap = {
                        count.value++
                        Log.e("floatView", "onTap")
                    },
                    onPress = { Log.e("floatView", "onPress") },
                    onDoubleTap = { Log.e("floatView", "onDoubleTap") },
                    onLongPress = { Log.e("floatView", "onLongPress") },
                 )*//*

                // 拖拽
                detectDragGestures(onDrag = { change, offset ->
                    change.consumeAllChanges()
                    offsetX += offset.x
                    offsetY += offset.y
                    Log.e("floatView", "floatView drag:  change: $change,  offset: $offset")
                })
            },*/
    ) {
        Text(text = count.value.toString(), color = Color.White,
            modifier = Modifier.align(Alignment.Center).background(Color.Cyan)
                .padding(horizontal = 18.dp, vertical = 4.dp)
        )
    }
}

/**
 * test code
    Column(Modifier.padding(start = 50.dp, top = 50.dp)) {
     ScrollVerticalView()
     Spacer(modifier = Modifier.size(20.dp))
     ScrollHorizontalView()
    }
 */
@Composable
fun ScrollVerticalView() {
    Column(
        Modifier.background(Color.Gray)
            .size(width = 150.dp, height = 90.dp)
            .verticalScroll(rememberScrollState())
    ) {
        repeat(10) {
            Text(text = "Item $it", modifier = Modifier.padding(2.dp))
        }
    }
}

@Composable
fun ScrollHorizontalView() {
    Row(
        Modifier.background(Color.Gray)
            .size(width = 70.dp, height = 100.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        repeat(10) {
            Text(text = "Item $it", modifier = Modifier.padding(2.dp))
        }
    }
}