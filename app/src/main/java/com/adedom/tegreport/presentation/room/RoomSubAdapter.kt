package com.adedom.tegreport.presentation.room

import android.view.View
import com.adedom.teg.models.report.three.RoomInfoHistory
import com.adedom.teg.util.TegConstant
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import kotlinx.android.synthetic.main.item_room_sub.view.*
import java.util.*

class RoomSubAdapter : SimpleRecyclerView<RoomInfoHistory>() {

    override fun getLayout(): Int = R.layout.item_room_sub

    override fun View.onBindViewHolder(currentData: RoomInfoHistory, beforeData: RoomInfoHistory?) {
        tvPlayerId.text = "- ${currentData.playerId}"
        tvName.text = currentData.name?.capitalize(Locale.getDefault())
        tvDateTime.text = currentData.dateTime

        if (currentData.team == TegConstant.TEAM_A) {
            ivTeam.setImageResource(R.drawable.shape_team_a)
        } else {
            ivTeam.setImageResource(R.drawable.shape_team_b)
        }

        if (currentData.status == TegConstant.ROOM_STATUS_READY) {
            ivStatus.setImageResource(R.drawable.shape_oval_green)
        } else {
            ivStatus.setImageResource(R.drawable.shape_oval_red)
        }

        if (currentData.role == TegConstant.ROOM_ROLE_HEAD) {
            ivRole.setImageResource(R.drawable.ic_king)
        } else {
            ivRole.setImageResource(R.drawable.ic_soldier)
        }
    }

    override fun getAreItemsTheSame(oldItem: RoomInfoHistory, newItem: RoomInfoHistory): Boolean {
        return oldItem.infoId == newItem.infoId
    }

}
