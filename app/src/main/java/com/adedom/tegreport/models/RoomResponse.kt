package com.adedom.tegreport.models

data class RoomResponse(
    val success: Boolean? = null,
    val message: String? = null,
    val roomAll: Int? = null,
    val rooms: List<Room> = emptyList(),
)
