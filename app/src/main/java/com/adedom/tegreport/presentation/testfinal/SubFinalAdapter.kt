package com.adedom.tegreport.presentation.testfinal

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.Data
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_sub_final.view.*

class SubFinalAdapter : SimpleRecyclerView<Data>() {

    override fun getLayout(): Int = R.layout.item_sub_final

    override fun View.onBindViewHolder(currentData: Data, beforeData: Data?) {
        tvBranchTotalScore.text = "รวมคะแนน ${currentData.branchTotalScore}"
        recyclerView.submitList(BranchFinalAdapter(), currentData.subData)
    }

    override fun getAreItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.dataId == newItem.dataId
    }

}
