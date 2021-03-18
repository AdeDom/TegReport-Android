package com.adedom.tegreport.presentation.logactive

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.LogActiveResponse
import com.adedom.tegreport.utils.ItemRecyclerView
import kotlinx.android.synthetic.main.item_log_active_footer.view.*

class LogActiveFooterAdapter : ItemRecyclerView<LogActiveResponse>() {

    override fun getLayout(): Int = R.layout.item_log_active_footer

    override fun View.onBindViewHolder() {
        val item = getData()

        tvPeopleAll.text = "รวมจำนวนผู้เล่น ${item?.peopleAll} คน"
        tvGrandTotalTimePeriod.text = "รวมระยะเวลาในเกมทั้งสิ้น ${item?.grandTotalTimePeriod}"
    }

}
