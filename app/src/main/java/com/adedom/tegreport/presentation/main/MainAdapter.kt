package com.adedom.tegreport.presentation.main

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter : SimpleRecyclerView<Pair<Int, String>>() {

    override fun getLayout(): Int = R.layout.item_main

    override fun View.onBindViewHolder(
        currentData: Pair<Int, String>,
        beforeData: Pair<Int, String>?
    ) {
        val report = "${currentData.first}. ${currentData.second}"
        tvReport.text = report
    }

}
