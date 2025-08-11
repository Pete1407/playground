package com.example.playgroundspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.areNavigationBarsVisible
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playgroundspace.ui.theme.PlaygroundSpaceTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var numberValue by remember { mutableIntStateOf(0) }

            PlaygroundSpaceTheme {

                Scaffold(
                    topBar = {
                        TitleSection()
                    },
                    content = { innerPadding ->
                        ContentSection(
                            numberValue = numberValue,
                            paddingValues = innerPadding
                        )
                    },
                    bottomBar = {
                        ButtonSection(
                            onClickButton = {
                              numberValue +=1
                            }
                        )
                    },
                    modifier = Modifier
                        .background(Color.Black)
                        .windowInsetsPadding(WindowInsets.systemBars)
                )
                    
                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleSection(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_text),
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
            scrolledContainerColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}

@Composable
fun ContentSection(
    numberValue : Int,
    paddingValues: PaddingValues
){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(colorResource(R.color.white))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = stringResource(R.string.description_text),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.spacing_small))
        )
        Spacer(modifier = Modifier.padding(top = dimensionResource(R.dimen.spacing_small)))
        Text(
            text = handleValue(textValue = numberValue),
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}

private fun handleValue(textValue : Int):String{
    return if(textValue == 0){
        "It's just ZERO value come on!"
    }else{
        textValue.toString()
    }
}

@Composable
fun ButtonSection(
    onClickButton : () -> Unit
){
    Row(modifier = Modifier.fillMaxWidth()){
        Button(
            modifier = Modifier
                .background(Color.White)
                .padding(
                    horizontal = dimensionResource(R.dimen.spacing_medium),
                    vertical = dimensionResource(R.dimen.spacing_medium)
                )
                .fillMaxWidth(),
            onClick = {
                onClickButton.invoke()
            }
        ){
            Text(
                text = stringResource(R.string.button_text)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowContentSection(){
    ContentSection(
        numberValue = 3,
        paddingValues = PaddingValues()
    )
}