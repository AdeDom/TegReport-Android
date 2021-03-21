package com.adedom.tegreport.models

data class ItemCollectionMode(
    val modeId: String? = null,
    val mode: String? = null,
    val itemQtyAll: Int? = null,
    val itemAll: Int? = null,
    val itemCollectionItems: List<ItemCollectionItem> = emptyList(),
)
