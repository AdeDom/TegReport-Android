package com.adedom.tegreport.presentation.testfinal

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SingleRecyclerView
import com.adedom.tegreport.utils.tegFormat
import kotlinx.android.synthetic.main.item_result_footer.view.*

class ResultFooterAdapter : SingleRecyclerView<Pair<Int?, Int?>>() {

    override fun getLayout(): Int = R.layout.item_result_footer

    override fun View.onBindViewHolder(data: Pair<Int?, Int?>?) {
        tvGrandTotalPeople.text = "รวมจำนวนผู้เล่น ${data?.first} คน"
        tvGrandTotalScore.text = "รวมคะแนน ${data?.second.tegFormat()}"
    }

}
