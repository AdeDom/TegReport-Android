package com.adedom.tegreport.presentation.logactive

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.LogActiveData
import com.adedom.tegreport.utils.SimpleRecyclerView
import kotlinx.android.synthetic.main.item_sub_log_active.view.*

class LogActiveSubAdapter : SimpleRecyclerView<LogActiveData>() {

    override fun getLayout(): Int = R.layout.item_sub_log_active

    override fun View.onBindViewHolder(currentData: LogActiveData, beforeData: LogActiveData?) {
        tvDateIn.text = currentData.dateIn
        tvTimeIn.text = currentData.timeIn
        tvDateOut.text = currentData.dateOut
        tvTimeOut.text = currentData.timeOut
        tvTimePeriod.text = currentData.timePeriod
    }

    override fun getAreItemsTheSame(oldItem: LogActiveData, newItem: LogActiveData): Boolean {
        return oldItem.dataId == newItem.dataId
    }

}
