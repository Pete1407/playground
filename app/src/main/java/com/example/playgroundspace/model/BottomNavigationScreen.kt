package com.example.playgroundspace.model

import androidx.annotation.StringRes
import com.example.playgroundspace.R

sealed class BottomNavigationScreen(
    val label : String,
    val route : String,
    val icon : Int
){

    object HomeScreen : BottomNavigationScreen("HomeScreen", "home_screen_route",R.drawable.ic_android)
    object SearchScreen : BottomNavigationScreen("SearchScreen","search_screen_route",R.drawable.ic_caske)
    object ProfileScreen : BottomNavigationScreen("ProfileScreen","profile_screen_route",R.drawable.ic_moon)

}