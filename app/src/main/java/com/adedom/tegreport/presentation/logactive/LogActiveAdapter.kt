package com.adedom.tegreport.presentation.logactive

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.LogActive
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_log_active.view.*

class LogActiveAdapter : SimpleRecyclerView<LogActive>() {

    override fun getLayout(): Int = R.layout.item_log_active

    override fun View.onBindViewHolder(currentData: LogActive, beforeData: LogActive?) {
        tvPlayerId.text = currentData.playerId
        tvName.text = currentData.name
        tvTime.text = "เข้าเล่นเกม ${currentData.time} ครั้ง"
        tvTotalTimePeriod.text = "รวมระยะเวลาในการเล่นเกม ${currentData.totalTimePeriod}"

        recyclerView.submitList(LogActiveSubAdapter(), currentData.logActiveData)
    }

    override fun getAreItemsTheSame(oldItem: LogActive, newItem: LogActive): Boolean {
        return oldItem.playerId == newItem.playerId
    }

}
