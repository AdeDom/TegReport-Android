package com.adedom.tegreport.presentation.room

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.Room
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_room.view.*
import java.util.*

class RoomAdapter : SimpleRecyclerView<Room>() {

    override fun getLayout(): Int = R.layout.item_room

    override fun View.onBindViewHolder(currentData: Room, beforeData: Room?) {
        tvRoomId.text = currentData.roomId.toString()
        tvRoomNo.text = currentData.roomNo
        tvName.text = currentData.name
        tvPeople.text = currentData.people.toString()
        tvStatus.text = currentData.status?.capitalize(Locale.getDefault())
        tvDateTime.text = currentData.dateTime
        tvPeopleAll.text = "จำนวนผู้เล่นที่อยู่ในห้อง ${currentData.peopleAll} คน"

        recyclerView.submitList(RoomSubAdapter(), currentData.roomInfo)
    }

    override fun getAreItemsTheSame(oldItem: Room, newItem: Room): Boolean {
        return oldItem.roomId == newItem.roomId
    }

}
