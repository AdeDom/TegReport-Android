package com.adedom.tegreport.models

data class Item(
    val itemId: String? = null,
    val itemType: String? = null,
    val itemQty: Int? = null,
    val collectionAll: Int? = null,
    val collections: List<Collection> = emptyList(),
)
