package com.adedom.tegreport.models

data class LogActiveResponse(
    val success: Boolean = false,
    val message: String? = null,
    val logActives: List<LogActive> = emptyList(),
)
