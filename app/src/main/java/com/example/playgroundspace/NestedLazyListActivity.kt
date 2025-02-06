package com.example.playgroundspace

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                                Text(text = "TopBar")
                            })
                    }) { innerPadding ->
                    SectionRecyclerView(innerPadding)
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

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @Composable
    private fun SectionRecyclerView(
        paddingValues: PaddingValues
    ) {
        NestedLazyListScreen(
            paddingValues,
            getProviderInfoModel(),
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
        fun navigate(context: Context) {
            val intent = Intent(context, NestedLazyListActivity::class.java)
            context.startActivity(intent)
        }
    }

}
