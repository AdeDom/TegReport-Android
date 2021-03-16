package com.adedom.tegreport.presentation.testfinal

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.ItemRecyclerView
import com.adedom.tegreport.utils.tegFormat
import kotlinx.android.synthetic.main.item_result_footer.view.*

class ResultFooterAdapter : ItemRecyclerView<Pair<Int?, Int?>>() {

    override fun getLayout(): Int = R.layout.item_result_footer

    override fun View.onBindViewHolder() {
        tvGrandTotalPeople.text = "รวมจำนวนผู้เล่น ${getData()?.first} คน"
        tvGrandTotalScore.text = "รวมคะแนน ${getData()?.second.tegFormat()}"
    }

}
