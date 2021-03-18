package com.adedom.tegreport.presentation.logactive

import android.view.View
import com.adedom.teg.models.report.two.LogActiveHistory
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_log_active.view.*

class LogActiveAdapter : SimpleRecyclerView<LogActiveHistory>() {

    override fun getLayout(): Int = R.layout.item_log_active

    override fun View.onBindViewHolder(
        currentData: LogActiveHistory,
        beforeData: LogActiveHistory?
    ) {
        tvPlayerId.text = currentData.playerId
        tvName.text = currentData.name
        tvTime.text = "เข้าเล่นเกม ${currentData.time} ครั้ง"
        tvTotalTimePeriod.text = "รวมระยะเวลาในการเล่นเกม ${currentData.totalTimePeriod}"

        recyclerView.submitList(LogActiveSubAdapter(), currentData.logActiveHistoryDataList)
    }

    override fun getAreItemsTheSame(oldItem: LogActiveHistory, newItem: LogActiveHistory): Boolean {
        return oldItem.playerId == newItem.playerId
    }

}
