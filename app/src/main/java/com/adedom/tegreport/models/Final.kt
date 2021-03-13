package com.adedom.tegreport.models

data class Final(
    val playerId: String? = null,
    val name: String? = null,
    val totalDate: Int? = null,
    val subTotalScore: Int? = null,
    val `data`: List<Data> = emptyList(),
)
