package com.adedom.tegreport.models

data class Player(
    val playerId: String? = null,
    val name: String? = null,
    val modeAll: Int? = null,
    val modes: List<Mode> = emptyList(),
)
