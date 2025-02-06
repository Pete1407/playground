package com.example.playgroundspace.model

data class ProviderInputModel(
    val field : String = "",
    val label : String = "",
    val regEx : String = "",
    val mandatory : Boolean = false,
    val type : KeyboardInputType = KeyboardInputType.TEXT
)
