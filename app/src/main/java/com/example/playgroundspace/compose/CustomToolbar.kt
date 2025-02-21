package com.example.playgroundspace.compose

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.playgroundspace.R
import com.example.playgroundspace.ui.theme.PlaygroundSpaceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolbar(
    title : String,
    isShowBackButton : Boolean
){
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White
        ),
        title = {
            Text(
                text = title,
                color = Color.White
            )
        },
        navigationIcon = {
            if(isShowBackButton){
                IconButton(onClick = {}){
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_back),
                        contentDescription = ""
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun ShowMyToolbarWithBackButton(){
    PlaygroundSpaceTheme {
        MyToolbar(
            title = "Title",
            true
        )
    }
}

@Preview
@Composable
fun ShowMyToolbar(){
    PlaygroundSpaceTheme {
        MyToolbar(
            title = "Title",
            false
        )
    }
}
