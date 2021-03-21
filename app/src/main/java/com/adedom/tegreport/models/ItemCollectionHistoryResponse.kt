package com.adedom.tegreport.models

data class ItemCollectionHistoryResponse(
    var itemAll: Int? = null,
    var playerAll: Int? = null,
    var itemCollectionPlayers: List<ItemCollectionPlayer> = emptyList(),
)
