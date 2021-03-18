package com.adedom.tegreport.models

data class Room(
    val roomId: Int? = null,
    val roomNo: String? = null,
    val name: String? = null,
    val people: Int? = null,
    val status: String? = null,
    val dateTime: String? = null,
    val peopleAll: Int? = null,
    val roomInfo: List<RoomInfo> = emptyList(),
)
