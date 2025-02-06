package com.example.playgroundspace.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.playgroundspace.R

@Composable
fun CategoryItemView(title : String){
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ItemView(logo : Int, subTitle : String){
        ConstraintLayout(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
            val (logoRef,subTitleRef) = createRefs()

            Image(
                painter = painterResource(logo),
                contentDescription = "title",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(48.dp)
                    .clip(CircleShape)
                    .border(2.dp, color = colorResource(R.color.border_shape_color), CircleShape)
                    .constrainAs(logoRef){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = subTitle,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(subTitleRef){
                        top.linkTo(logoRef.bottom, margin = 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                textAlign = TextAlign.Center
            )
        }
}

@Preview
@Composable
fun ShowCategoryItemView(){
    CategoryItemView(
        title = "WATER AND ELECTRICITY BILLS"
    )
}

@Preview
@Composable
fun ShowItemView(){
    Row(modifier = Modifier.background(Color.White)){
        ItemView(
            logo = R.drawable.ic_launcher_foreground,
            subTitle = "Admiral Kizaru"
        )
    }

}