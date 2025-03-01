package com.example.playgroundspace.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playgroundspace.R
import com.example.playgroundspace.model.AdditionalCharacterModel
import com.example.playgroundspace.model.HalloweenCharacterModel
import com.example.playgroundspace.ui.theme.Typography
import com.example.playgroundspace.ui.theme.orange_halloween

@Composable
fun HalloweenCharacterItem(
    characterInfo : HalloweenCharacterModel,
    onSelectedItem : ((HalloweenCharacterModel) -> Unit)
){
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(16.dp),
        onClick = {
            onSelectedItem(characterInfo)
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ){
        Column(modifier = Modifier.background(color = Color.Red)){
            Image(
                painter = painterResource(characterInfo.image),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()

            )

            Row{
                Text(
                    text = characterInfo.name,
                    fontStyle = FontStyle.Normal,
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

        Column(
            modifier = Modifier.background(Color.White)
        ){
            characterInfo.additionalCharacterList.forEach {
                AdditionalCharacterInfoItemView(it)
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().background(Color.White)
        ){
            Button(
                onClick = {
                    onSelectedItem(characterInfo)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.see_detail),
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    painterResource(R.drawable.ic_arrow_right),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }


    }
}

@Composable
fun AdditionalCharacterInfoItemView(info : AdditionalCharacterModel){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ){
        Text(
            text = info.infoField
        )
        Text(
            text = info.valueField
        )
    }
}

@Preview
@Composable
fun ShowHalloweenCharacterItem(){
    HalloweenCharacterItem(
        HalloweenCharacterModel(),
        onSelectedItem = {}
    )
}