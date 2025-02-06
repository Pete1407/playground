package com.example.playgroundspace.model

import com.example.playgroundspace.R

data class ProviderInfoInputModel(
    val providerCode : String = "",
    val providerName : String = "",
    val iconUrl : Int = R.drawable.ic_launcher_foreground,
    val inputs : List<ProviderInputModel> = listOf(),
    val remark : String? = null,
    val remarkUrl : String? = null
)
