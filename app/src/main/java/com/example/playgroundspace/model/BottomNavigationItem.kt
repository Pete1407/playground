package com.example.playgroundspace.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Person,
    val route : String = ""
){
    fun bottomNavigationItems() : List<BottomNavigationItem>{
        return listOf(
            // item 1
            BottomNavigationItem(
                label = "Home",
                icon = Screens.Home.icon,
                route = Screens.Home.route
            ),
            // item 2
            BottomNavigationItem(
                label = "Search",
                icon = Screens.Search.icon,
                route = Screens.Search.route
            ),
            // item 3
            BottomNavigationItem(
                label = "Person",
                icon = Screens.Profile.icon,
                route = Screens.Profile.route
            ),
        )
    }
}
