package com.adedom.tegreport.models

data class FinalResponse(
    val success: Boolean? = null,
    val message: String? = null,
    val grandTotalPeople: Int? = null,
    val grandTotalScore: Int? = null,
    val finals: List<Final> = emptyList(),
)
