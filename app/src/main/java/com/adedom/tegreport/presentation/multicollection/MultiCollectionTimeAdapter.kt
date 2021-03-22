package com.adedom.tegreport.presentation.multicollection

import android.view.View
import com.adedom.teg.models.report.five.MultiCollectionTime
import com.adedom.teg.util.TegConstant
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import kotlinx.android.synthetic.main.item_multi_collection_time.view.*

class MultiCollectionTimeAdapter : SimpleRecyclerView<MultiCollectionTime>() {

    override fun getLayout(): Int = R.layout.item_multi_collection_time

    override fun View.onBindViewHolder(
        currentData: MultiCollectionTime,
        beforeData: MultiCollectionTime?
    ) {
        if (currentData.roomNo == beforeData?.roomNo) {
            tvRoomNo.visibility = View.INVISIBLE
        }

        if (currentData.playerId == beforeData?.playerId) {
            tvPlayerId.visibility = View.INVISIBLE
        }

        if (currentData.name == beforeData?.name) {
            tvName.visibility = View.INVISIBLE
        }

        if (currentData.team == beforeData?.team) {
            ivTeam.visibility = View.INVISIBLE
        }

        tvTime.text = currentData.time
        tvRoomNo.text = currentData.roomNo
        tvPlayerId.text = currentData.playerId
        tvName.text = currentData.name

        if (currentData.team == TegConstant.TEAM_A) {
            ivTeam.setImageResource(R.drawable.shape_team_a)
        } else {
            ivTeam.setImageResource(R.drawable.shape_team_b)
        }
    }

    override fun getAreItemsTheSame(
        oldItem: MultiCollectionTime,
        newItem: MultiCollectionTime
    ): Boolean {
        return oldItem.timeId == newItem.timeId
    }

}
