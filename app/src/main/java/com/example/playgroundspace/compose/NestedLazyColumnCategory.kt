package com.example.playgroundspace.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Expanded
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Medium
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playgroundspace.R
import com.example.playgroundspace.model.ProviderInfoModel
import kotlin.math.min

@Composable
fun NestedLazyListScreen(
    paddingValues: PaddingValues,
    providerList: List<ProviderInfoModel>
) {
    val configuration = LocalConfiguration.current
    val smallestWidthDp = configuration.screenWidthDp


    val columns = when {
        smallestWidthDp < 360 -> 3
        else -> 4
    }

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .background(color = colorResource(R.color.bg_app))
    ) {
        itemsIndexed(providerList) { index, item ->

            if (index == 0) {
                ShowHistoryView()
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))
            Card(
                shape = RectangleShape,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                CategoryItemView(
                    title = item.categoryName
                )

                VerticalGrid(
                    modifier = Modifier.padding(8.dp),
                    composableList = item.providers.map {
                        {
                            ItemView(
                                logo = it.iconUrl,
                                subTitle = it.providerName
                            )
                        }
                    },
                    itemsPerRow = columns,
                    verticalSpace = 8.dp,
                    horizontalSpace = 16.dp
                )
            }
        }
    }
}

@Composable
fun ShowHistoryView() {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(color = Color.White)
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.ic_utility_menu),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = "รายการที่สมัครผูกชำระ",
                color = colorResource(R.color.color_text),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun ShowHistoryComponent() {
    ShowHistoryView()
}


