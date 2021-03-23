package com.adedom.tegreport.models

data class SingleItemDate(
    val dateId: String? = null,
    val date: String? = null,
    val timeAll: Int? = null,
    val singleItemTimes: List<SingleItemTime> = emptyList(),
)
