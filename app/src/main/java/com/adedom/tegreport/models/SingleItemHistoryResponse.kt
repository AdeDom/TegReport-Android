package com.adedom.tegreport.models

data class SingleItemHistoryResponse(
    var dateAll: Int? = null,
    var singleItemDates: List<SingleItemDate> = emptyList(),
)
