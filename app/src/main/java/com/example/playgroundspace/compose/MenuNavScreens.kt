package com.example.playgroundspace.compose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.playgroundspace.R
import com.example.playgroundspace.model.AdditionalCharacterModel
import com.example.playgroundspace.model.HalloweenCharacterModel
import com.example.playgroundspace.view.HalloweenCharacterItem

@Composable
fun HomeScreen(
    onSelectCharacter : ((HalloweenCharacterModel) -> Unit)
){
   LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)){
       items(getHalloweenCharacterList()){ character ->
           HalloweenCharacterItem(characterInfo = character){
               onSelectCharacter(it)
           }
       }
   }
}

private fun getHalloweenCharacterList():List<HalloweenCharacterModel>{
    return listOf(
        HalloweenCharacterModel(
            name = "Ghost Halloween",
            image = R.drawable.death_hallowen,
            attack = 30,
            speed = 50,
            defense = 50,
            additionalCharacterList = listOf(
                AdditionalCharacterModel(
                    infoField = "FirstName:",
                    valueField = "Timothy",
                ),
                AdditionalCharacterModel(
                    infoField = "Attack",
                    valueField = "100",
                ),
                AdditionalCharacterModel(
                    infoField = "Defense",
                    valueField = "500",
                ),
                AdditionalCharacterModel(
                    infoField = "Speed",
                    valueField = "600",
                )
            )
        ),
        HalloweenCharacterModel(
            name = "Phenix",
            image = R.drawable.logo_blackbeard,
            attack = 100,
            speed = 80,
            defense = 100,
            additionalCharacterList = listOf(
                AdditionalCharacterModel(
                    infoField = "FirstName",
                    valueField = "Goodness",
                ),
                AdditionalCharacterModel(
                    infoField = "Strategy",
                    valueField = "5 stars",
                ),
                AdditionalCharacterModel(
                    infoField = "Speed",
                    valueField = "1000",
                ),
                AdditionalCharacterModel(
                    infoField = "Defense",
                    valueField = "100",
                )
            )
        ),
        HalloweenCharacterModel(
            name = "Azel",
            image = R.drawable.logo_makima,
            attack = 10000,
            speed = 10000,
            defense = 7000,
            additionalCharacterList = listOf(
                AdditionalCharacterModel(
                    infoField = "Position",
                    valueField = "God's assistant",
                ),
                AdditionalCharacterModel(
                    infoField = "Attack",
                    valueField = "10000",
                ),
                AdditionalCharacterModel(
                    infoField = "Defense",
                    valueField = "7000",
                ),
                AdditionalCharacterModel(
                    infoField = "Speed",
                    valueField = "10000",
                )
            )
        ),
        HalloweenCharacterModel(
            name = "Phenix",
            attack = 100,
            speed = 80,
            defense = 100,
            additionalCharacterList = listOf(
                AdditionalCharacterModel(
                    infoField = "FirstName",
                    valueField = "Goodness",
                ),
                AdditionalCharacterModel(
                    infoField = "Strategy",
                    valueField = "2 stars",
                ),
                AdditionalCharacterModel(
                    infoField = "Speed",
                    valueField = "6000",
                ),
                AdditionalCharacterModel(
                    infoField = "Defense",
                    valueField = "50",
                )
            )
        ),
        HalloweenCharacterModel(
            name = "Phenix",
            image = R.drawable.logo_kizaru,
            attack = 100,
            speed = 80,
            defense = 100,
            additionalCharacterList = listOf(
                AdditionalCharacterModel(
                    infoField = "FirstName",
                    valueField = "Goodness",
                ),
                AdditionalCharacterModel(
                    infoField = "Strategy",
                    valueField = "4 stars",
                ),
                AdditionalCharacterModel(
                    infoField = "Speed",
                    valueField = "1000",
                ),
                AdditionalCharacterModel(
                    infoField = "Defense",
                    valueField = "80",
                )
            )
        )
    )
}

@Composable
fun SearchScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        contentColor = Color.Blue
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "SearchScreen",
                color = Color.Black,
                fontSize = 40.sp
            )
        }
    }
}

@Composable
fun ProfileScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        contentColor = Color.Blue
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "ProfileScreen",
                color = Color.Black,
                fontSize = 40.sp
            )
        }
    }
}