package com.adedom.tegreport.presentation.multicollection

import android.view.View
import com.adedom.teg.models.report.five.MultiCollectionDate
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_multi_collection_date.view.*

class MultiCollectionDateAdapter : SimpleRecyclerView<MultiCollectionDate>() {

    override fun getLayout(): Int = R.layout.item_multi_collection_date

    override fun View.onBindViewHolder(
        currentData: MultiCollectionDate,
        beforeData: MultiCollectionDate?
    ) {
        tvDate.text = currentData.date
        tvTimeAll.text = "รวมเวลาทั้งหมด ${currentData.timeAll} รายการ"

        recyclerView.submitList(MultiCollectionTimeAdapter(), currentData.multiCollectionTimes)
    }

    override fun getAreItemsTheSame(
        oldItem: MultiCollectionDate,
        newItem: MultiCollectionDate
    ): Boolean {
        return oldItem.dateId == newItem.dateId
    }

}
