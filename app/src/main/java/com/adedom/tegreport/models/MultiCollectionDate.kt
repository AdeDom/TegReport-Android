package com.adedom.tegreport.models

data class MultiCollectionDate(
    val dateId: String? = null,
    val date: String? = null,
    val timeAll: Int? = null,
    val multiCollectionTimes: List<MultiCollectionTime> = emptyList(),
)
