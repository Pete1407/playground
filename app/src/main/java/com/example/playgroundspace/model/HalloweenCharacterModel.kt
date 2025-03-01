package com.example.playgroundspace.model

import androidx.annotation.DrawableRes
import com.example.playgroundspace.R

data class HalloweenCharacterModel(
    @DrawableRes val image : Int = R.drawable.ghost_halloween,
    val name: String = "",
    val attack: Int = 0,
    val speed: Int = 0,
    val defense: Int = 0,
    val additionalCharacterList: List<AdditionalCharacterModel> = listOf()
)

data class AdditionalCharacterModel(
    val infoField: String = "",
    val valueField : String = "",
)