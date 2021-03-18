package com.adedom.tegreport.presentation.logactive

import android.view.View
import com.adedom.teg.models.report.two.LogActiveHistoryData
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import kotlinx.android.synthetic.main.item_sub_log_active.view.*

class LogActiveSubAdapter : SimpleRecyclerView<LogActiveHistoryData>() {

    override fun getLayout(): Int = R.layout.item_sub_log_active

    override fun View.onBindViewHolder(
        currentData: LogActiveHistoryData,
        beforeData: LogActiveHistoryData?
    ) {
        tvDateIn.text = currentData.dateIn
        tvTimeIn.text = currentData.timeIn
        tvDateOut.text = currentData.dateOut
        tvTimeOut.text = currentData.timeOut
        tvTimePeriod.text = currentData.timePeriod
    }

    override fun getAreItemsTheSame(
        oldItem: LogActiveHistoryData,
        newItem: LogActiveHistoryData
    ): Boolean {
        return oldItem.dataId == newItem.dataId
    }

}
