package com.adedom.tegreport.models

data class Data(
    val dataId: Int? = null,
    val branchTotalScore: Int? = null,
    val subData: List<SubData> = emptyList(),
)
