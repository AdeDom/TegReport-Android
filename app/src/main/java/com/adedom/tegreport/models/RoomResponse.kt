package com.adedom.tegreport.models

data class RoomResponse(
    val roomAll: Int? = null,
    val rooms: List<Room> = emptyList(),
)
