package com.adedom.tegreport.presentation.room

import android.view.View
import com.adedom.teg.models.report.three.RoomHistory
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_room.view.*
import java.util.*

class RoomAdapter : SimpleRecyclerView<RoomHistory>() {

    override fun getLayout(): Int = R.layout.item_room

    override fun View.onBindViewHolder(currentData: RoomHistory, beforeData: RoomHistory?) {
        tvRoomId.text = currentData.roomId.toString()
        tvRoomNo.text = currentData.roomNo
        tvName.text = currentData.name
        tvPeople.text = currentData.people.toString()
        tvStatus.text = currentData.status?.capitalize(Locale.getDefault())
        tvDateTime.text = currentData.dateTime
        tvPeopleAll.text = "จำนวนผู้เล่นที่อยู่ในห้อง ${currentData.peopleAll} คน"

        recyclerView.submitList(RoomSubAdapter(), currentData.roomInfoHistories)
    }

    override fun getAreItemsTheSame(oldItem: RoomHistory, newItem: RoomHistory): Boolean {
        return oldItem.roomId == newItem.roomId
    }

}
