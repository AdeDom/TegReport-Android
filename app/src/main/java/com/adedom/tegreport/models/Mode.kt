package com.adedom.tegreport.models

data class Mode(
    val modeId: String? = null,
    val mode: String? = null,
    val itemQtyAll: Int? = null,
    val itemAll: Int? = null,
    val items: List<Item> = emptyList(),
)
