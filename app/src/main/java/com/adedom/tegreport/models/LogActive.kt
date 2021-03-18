package com.adedom.tegreport.models

data class LogActive(
    val playerId: String? = null,
    val name: String? = null,
    val image: String? = null,
    val time: Int? = null,
    val totalTimePeriod: String? = null,
    val logActiveData: List<LogActiveData> = emptyList(),
)
