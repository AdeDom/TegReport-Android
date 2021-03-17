package com.adedom.tegreport.models

data class PlayerResponse(
    val success: Boolean = false,
    val message: String? = null,
    val gamePlayerRankings: List<GamePlayerRanking> = emptyList(),
)
