package com.adedom.tegreport.presentation.testfinal

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.SubData
import com.adedom.tegreport.utils.SimpleRecyclerView
import kotlinx.android.synthetic.main.item_branch_final.view.*

class BranchFinalAdapter : SimpleRecyclerView<SubData>() {

    override fun getLayout(): Int = R.layout.item_branch_final

    override fun View.onBindViewHolder(currentData: SubData, beforeData: SubData?) {
        if (currentData.date == beforeData?.date) {
            tvDate.visibility = View.INVISIBLE
        }

        tvDate.text = currentData.date
        tvTime.text = currentData.time
        tvItemA.text = currentData.itemA.toString()
        tvItemB.text = currentData.itemB.toString()
        tvItemC.text = currentData.itemC.toString()
        tvItemD.text = currentData.itemD.toString()
        tvTotalScore.text = currentData.totalScore.toString()
    }

    override fun getAreItemsTheSame(oldItem: SubData, newItem: SubData): Boolean {
        return oldItem.subDataId == newItem.subDataId
    }

}
