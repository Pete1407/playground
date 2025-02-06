package com.example.playgroundspace.model

data class ProviderInfoModel(
    val category : CategoryTypeEnum = CategoryTypeEnum.OTHER,
    val categoryName : String = "",
    val providers : List<ProviderInfoInputModel> = listOf()
)
