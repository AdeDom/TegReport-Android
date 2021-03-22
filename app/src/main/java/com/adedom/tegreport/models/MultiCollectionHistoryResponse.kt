package com.adedom.tegreport.models

data class MultiCollectionHistoryResponse(
    var dateAll: Int? = null,
    var multiCollectionDates: List<MultiCollectionDate> = emptyList(),
)
