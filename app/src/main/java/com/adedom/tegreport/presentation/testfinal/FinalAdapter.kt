package com.adedom.tegreport.presentation.testfinal

import android.view.View
import com.adedom.teg.models.report.testfinal.Final
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import com.adedom.tegreport.utils.tegFormat
import kotlinx.android.synthetic.main.item_final.view.*

class FinalAdapter : SimpleRecyclerView<Final>() {

    override fun getLayout(): Int = R.layout.item_final

    override fun View.onBindViewHolder(currentData: Final, beforeData: Final?) {
        tvPlayerId.text = currentData.playerId
        tvName.text = currentData.name
        tvTotalDate.text = "รวม ${currentData.totalDate} วัน"
        tvSubTotalScore.text = "รวมคะแนน ${currentData.subTotalScore.tegFormat()}"
        recyclerView.submitList(SubFinalAdapter(), currentData.data)
    }

    override fun getAreItemsTheSame(oldItem: Final, newItem: Final): Boolean {
        return oldItem.playerId == newItem.playerId
    }

}
