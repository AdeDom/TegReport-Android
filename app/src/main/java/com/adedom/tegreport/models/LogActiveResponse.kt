package com.adedom.tegreport.models

data class LogActiveResponse(
    val success: Boolean = false,
    val message: String? = null,
    val peopleAll: Int? = null,
    val grandTotalTimePeriod: String? = null,
    val logActives: List<LogActive> = emptyList(),
)
