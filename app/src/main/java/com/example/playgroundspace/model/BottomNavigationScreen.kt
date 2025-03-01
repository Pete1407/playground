package com.example.playgroundspace.model

import androidx.annotation.StringRes
import com.example.playgroundspace.R

sealed class BottomNavigationScreen(
    val label : String,
    val route : String,
    val icon : Int
){

    object Frankendroid : BottomNavigationScreen("Frankendroid", "frankendroid_route",R.drawable.ic_android)
    object Pumpkin : BottomNavigationScreen("Pumpkin","pumpkin_screen_route",R.drawable.ic_caske)
    object Ghost : BottomNavigationScreen("Ghost","ghost_screen_route",R.drawable.ic_moon)

}