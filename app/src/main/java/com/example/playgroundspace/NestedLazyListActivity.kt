package com.example.playgroundspace

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.playgroundspace.compose.NestedLazyListScreen
import com.example.playgroundspace.model.CategoryTypeEnum
import com.example.playgroundspace.model.KeyboardInputType
import com.example.playgroundspace.model.ProviderInfoInputModel
import com.example.playgroundspace.model.ProviderInfoModel
import com.example.playgroundspace.model.ProviderInputModel
import com.example.playgroundspace.ui.theme.PlaygroundSpaceTheme

class NestedLazyListActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            modifier = Modifier.shadow(elevation = 8.dp),
                            title = {
                                Row {
                                    Text(text = "TopBar")
                                }
                            })
                    }) { innerPadding ->
                    MainScreenView(innerPadding)
                }
            }
        }
    }

    @Composable
    private fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    private fun GreetingPreview() {
        PlaygroundSpaceTheme {
            Greeting("Android")
        }
    }

    @Composable
    private fun MainScreenView(
        paddingValue: PaddingValues
    ) {
        SectionConditionView(paddingValue)
    }

    @Composable
    private fun SectionConditionView(
        paddingValues: PaddingValues
    ) {
        if (SHOW_LIST_OR_GAME) {
            NestedLazyListScreen(
                paddingValues,
                getProviderInfoModel(),
            )
        } else {
            LottieAnimationView(paddingValues)
        }
    }

    @Composable
    private fun LottieAnimationView(
        paddingValues: PaddingValues
    ) {
        
        val userTabCount = remember {
            mutableIntStateOf(0)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(paddingValues),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable(true) {
                        userTabCount.value+=1
                    }
            ) {
                ShowLottieAnimation(
                    lottieFile = R.raw.lottie_animation_01,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                )
            }

            Box(
                modifier = Modifier
                    .background(Color.Yellow)
                    .fillMaxHeight()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = userTabCount.intValue.toString(),
                    fontSize = 35.sp
                )
            }

            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable(true) {
                        userTabCount.value+=1
                    }
            ) {
                ShowLottieAnimation(
                    lottieFile = R.raw.lottie_animation_02,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                )
            }
        }
    }

    @Composable
    fun ShowLottieAnimation(
        modifier: Modifier = Modifier,
        lottieFile: Int
    ) {
        val preloaderLottieComposition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(
                lottieFile
            )
        )
        val preloaderProgress by animateLottieCompositionAsState(
            preloaderLottieComposition,
            iterations = LottieConstants.IterateForever,
            isPlaying = true
        )
        LottieAnimation(
            composition = preloaderLottieComposition,
            progress = preloaderProgress,
            modifier = modifier
        )
    }


    private fun getProviderInfoModel(): List<ProviderInfoModel> {
        return listOf(
            // CATEGORY 1
            ProviderInfoModel(
                category = CategoryTypeEnum.PHONE,
                categoryName = "โทรศัพท์",
                providers = listOf(
                    // item 1
                    ProviderInfoInputModel(
                        providerCode = "PHONE01",
                        providerName = "PHONE01",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 2
                    ProviderInfoInputModel(
                        providerCode = "PHONE02",
                        providerName = "PHONE02",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 3
                    ProviderInfoInputModel(
                        providerCode = "PHONE03",
                        providerName = "PHONE03",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    )
                )
            ),
            // CATEGORY 2
            ProviderInfoModel(
                category = CategoryTypeEnum.INTERNET,
                categoryName = "อินเทอร์เน็ต",
                providers = listOf(
                    // item 1
                    ProviderInfoInputModel(
                        providerCode = "Internet01",
                        providerName = "My world is hier",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.NUMBER
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 2
                    ProviderInfoInputModel(
                        providerCode = "Internet02",
                        providerName = "Cloud nine",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.NUMBER
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 3
                    ProviderInfoInputModel(
                        providerCode = "Internet03",
                        providerName = "DTAC",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.NUMBER
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 4
                    ProviderInfoInputModel(
                        providerCode = "Internet04",
                        providerName = "AIS Fibre",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.NUMBER
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 5
                    ProviderInfoInputModel(
                        providerCode = "Internet05",
                        providerName = "3BB",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.NUMBER
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    )
                )
            ),
            // CATEGORY 3
            ProviderInfoModel(
                category = CategoryTypeEnum.OTHER,
                categoryName = "Cartoon",
                providers = listOf(
                    // item 1
                    ProviderInfoInputModel(
                        providerCode = "BIGMOM101",
                        providerName = "BIGMOM101",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.NUMBER
                            )
                        ),
                        remark = null,
                        remarkUrl = null
                    ),
                    ProviderInfoInputModel(
                        providerCode = "FUJITORA102",
                        providerName = "FUJITORA102",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = null,
                        remarkUrl = null
                    )
                )
            ),
            // category 4
            ProviderInfoModel(
                category = CategoryTypeEnum.UTILITY,
                categoryName = "Utility",
                providers = listOf(
                    // item 1
                    ProviderInfoInputModel(
                        providerCode = "Utility01",
                        providerName = "Utility01",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 2
                    ProviderInfoInputModel(
                        providerCode = "Utility02",
                        providerName = "Utility02",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 3
                    ProviderInfoInputModel(
                        providerCode = "Utility03",
                        providerName = "Utility03",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 4
                    ProviderInfoInputModel(
                        providerCode = "Utility04",
                        providerName = "Utility04",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 5
                    ProviderInfoInputModel(
                        providerCode = "Utility05",
                        providerName = "Utility05",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    )
                )
            ),
            // category 5
            ProviderInfoModel(
                category = CategoryTypeEnum.OTHER,
                categoryName = "OTHER",
                providers = listOf(
                    // item 1
                    ProviderInfoInputModel(
                        providerCode = "PHONE01",
                        providerName = "PHONE01",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 2
                    ProviderInfoInputModel(
                        providerCode = "PHONE02",
                        providerName = "PHONE02",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    ),
                    // item 3
                    ProviderInfoInputModel(
                        providerCode = "PHONE03",
                        providerName = "PHONE03",
                        inputs = listOf(
                            ProviderInputModel(
                                field = "merchantField1",
                                label = "Phone number",
                                regEx = "regEx regEx ha!!!",
                                mandatory = true,
                                type = KeyboardInputType.TEXT
                            )
                        ),
                        remark = "remarkText",
                        remarkUrl = "remark garp grap"
                    )
                )
            )
        )

    }


    companion object {
        const val SHOW_LIST_OR_GAME = false

        fun navigate(context: Context) {
            val intent = Intent(context, NestedLazyListActivity::class.java)
            context.startActivity(intent)
        }
    }

}
