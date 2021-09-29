package com.bzb.challenge.ui.tab

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bzb.challenge.R
import com.bzb.challenge.data.DogInfo
import com.bzb.challenge.theme.bg_item_home
import com.bzb.challenge.ui.common.*
import com.bzb.challenge.ui.slide.SlidePageView
import com.bzb.challenge.util.loadImg
import kotlinx.coroutines.launch

/**
 * @author bzb
 * @date 2021/3/1 17:08
 * @description 首页tab
 */

@Composable
fun HomePage(scaffoldState: ScaffoldState) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBarView(
                title = { TitleView() },
                icon = { CircleHeadView(40.dp) {
                    coroutineScope.launch { scaffoldState.drawerState.open() }
                } },
                action = { ActionView() }
            )
        },
        drawerBackgroundColor = Color.Transparent,
        drawerContent = {
            SlidePageView(scaffoldState)
        },
    ) {
        Box(Modifier.fillMaxSize()) {
            Column(Modifier.fillMaxSize()) {
//            CustomTitleView()

                val listData = mutableStateListOf<DogInfo>()

                makeData(listData)

                RecommendListView(listData) {
                    CustomImageView(
                        modifier = Modifier.size(450.dp, 250.dp),
                        imgRes = R.drawable.dog_10
                    )
                }
            }
        }
    }
}


// 制造list数据
fun makeData(listData: SnapshotStateList<DogInfo>) {
    listData.add(DogInfo("Gracie", "So You’ve Been Kicked Out Of Doggy Daycare: What Next?", R.drawable.dog_1,
        "https://www.dogtime.com/assets/uploads/2015/06/kicked-out-doggy-day-care-1.jpg",
        "https://dogtime.com/reference/dog-daycare/21984-doggie-daycare-dropout"))

    listData.add(
        DogInfo("Bella","Separation Anxiety: When You’ve Got It Bad", R.drawable.dog_2,
    "https://www.dogtime.com/assets/uploads/2012/11/file_16507_Dog-repellant-600x600.jpg",
    "https://dogtime.com/reference/dog-daycare/3370-separation-anxiety-fido-friendly-carol-bryant")
    )

    listData.add(
        DogInfo("Chloe","Keep pet dogs from destroying your apartment", R.drawable.dog_3,
    "https://www.dogtime.com/assets/uploads/2015/07/file_26994_national-mutts-day-3-600x400.jpg",
    "https://dogtime.com/reference/dog-daycare/16507-keep-pet-dogs-from-destroying-your-apartment")
    )

    listData.add(
        DogInfo("Lola","How can I stop my puppy from chewing everything in sight?", R.drawable.dog_4,
    "https://www.dogtime.com/assets/uploads/2011/03/dog-crate-600x400.jpg",
    "https://dogtime.com/reference/dog-daycare/5124-stop-puppy-chewing-wilde-faq")
    )

    listData.add(
        DogInfo("Gracie","Find a dog walker, How do I choose a dog walker?", R.drawable.dog_5,
    "https://www.dogtime.com/assets/uploads/2015/07/file_26994_column_national-mutts-day-2.jpg",
    "https://dogtime.com/reference/dog-daycare/5147-choose-dog-walker-alonso-faq")
    )

    listData.add(
        DogInfo("Rocky","Puppies: Cute Pictures, Facts, & What You Should Know Before Adoption", R.drawable.dog_6,
            "https://www.dogtime.com/assets/uploads/2018/10/puppies-cover.jpg",
            "https://dogtime.com/puppies/255-puppies#/slide/1")
    )

    listData.add(
        DogInfo("Breed", "Alaskan Malamute Puppies: Cute Pictures And Facts", R.drawable.dog_10,
            "https://www.dogtime.com/assets/uploads/2019/05/alaskan-malamute-puppy-1.jpg",
            "https://dogtime.com/puppies/75761-alaskan-malamute-puppies")
    )

    listData.add(
        DogInfo("Babies","Find a dog walker, How do I choose a dog walker?", R.drawable.dog_7,
            "https://www.dogtime.com/assets/uploads/2016/09/shiba-inu-puppy-11-e1567108681949.jpg",
            "https://dogtime.com/puppies/43159-shiba-inu-puppies#/slide/1")
    )

    listData.add(
        DogInfo("Sammy","Holiday Puppies: A Nightmare After Christmas?", R.drawable.dog_8,
            "https://www.dogtime.com/assets/uploads/2015/07/file_26994_column_national-mutts-day-2.jpg",
            "https://dogtime.com/puppies/1261-holiday-puppies-nightmare")
    )

    listData.add(
        DogInfo("Teddy","Corgi Puppies: Cute Pictures And Facts", R.drawable.dog_9,
            "https://www.dogtime.com/assets/uploads/2016/08/corgi-puppy-6-e1573588370274.jpg",
            "https://dogtime.com/puppies/43021-corgi-puppies#/slide/1")
    )

//    listData.add(DogInfo())
}


/**
 * 首页推荐列表
 * @param modifier listView的modifier
 */
// https://developer.android.com/jetpack/compose/lists
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendListView(listData: List<DogInfo>, modifier: Modifier = Modifier, header: @Composable LazyItemScope.() -> Unit) {
    LazyColumn(/*contentPadding = PaddingValues(5.dp),*/ modifier = modifier) {

        // header
        stickyHeader { header() }

        // item
        items(listData) { info ->
            Box(Modifier.fillMaxWidth().padding(10.dp).background(bg_item_home, RoundedCornerShape(5.dp))) {

                val imageModifier = Modifier.size(130.dp, 150.dp).padding(10.dp).clip(RoundedCornerShape(4.dp))
                if (info.image != 0 || info.imgUrl.isNullOrEmpty()) {
                    Image(
                        painter = painterResource(info.image),
                        contentDescription = "Dog",
                        contentScale = ContentScale.Crop,
                        modifier = imageModifier
                    )
                } else {
                    CustomImageView(imageModifier, info.imgUrl)
                }


                Text(
                    text = info.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
//                    fontStyle = MaterialTheme.typography.h4,
                    modifier = Modifier
                        .padding(start = 150.dp, end = 10.dp, top = 20.dp)
                )

                Text(
                    text = info.desc,
                    modifier = Modifier
                        .padding(start = 150.dp, end = 10.dp, top = 50.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotoGrid(listData: List<DogInfo>) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(listData) { info ->
            if (info.imgUrl.isNullOrEmpty()) {
                Image(painterResource(id = info.image), contentDescription = "")
            } else {
                CustomImageView(imgUrl = info.imgUrl)
            }
        }
    }
}


@Composable
fun CustomTitleView() {
    val contentTitle = remember { mutableStateOf("Hello Compose!") }
    AndroidView(
        factory = { context ->
            TextView(context).apply {
                text = contentTitle.value
                textSize = 18f
            }
        },
        update = {
            // View's been inflated or state read in this block has been updated
            // Add logic here if necessary
            // 修改contentTitle，自动更新
            contentTitle.value = "Compose niubillty!"
        }
    )
}

@Composable
fun CustomImageView(modifier: Modifier = Modifier, imgUrl: String? = null, @DrawableRes imgRes: Int = 0) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            ImageView(context).apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
                if (imgUrl.isNullOrEmpty()) loadImg(imgRes) else loadImg(imgUrl)
            }
        },
        update = { /*v -> v.loadImg(imgUrl)*/ }
    )
}
