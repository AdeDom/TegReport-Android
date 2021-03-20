package com.adedom.tegreport.presentation.logactive

import android.view.View
import com.adedom.teg.models.report.two.LogActiveHistoryResponse
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SingleRecyclerView
import kotlinx.android.synthetic.main.item_log_active_footer.view.*

class LogActiveFooterAdapter : SingleRecyclerView<LogActiveHistoryResponse>() {

    override fun getLayout(): Int = R.layout.item_log_active_footer

    override fun View.onBindViewHolder(data: LogActiveHistoryResponse?) {
        tvPeopleAll.text = "รวมจำนวนผู้เล่น ${data?.peopleAll} คน"
        tvGrandTotalTimePeriod.text = "รวมระยะเวลาในเกมทั้งสิ้น ${data?.grandTotalTimePeriod}"
    }

}
