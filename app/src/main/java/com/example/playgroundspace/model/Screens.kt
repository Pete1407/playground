package com.example.playgroundspace.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route : String,val icon : ImageVector){
    object Home : Screens("home_route",Icons.Filled.Home)
    object Search : Screens("search_route", icon = Icons.Filled.Search)
    object Profile : Screens("profile_route", icon = Icons.Filled.Person)
}