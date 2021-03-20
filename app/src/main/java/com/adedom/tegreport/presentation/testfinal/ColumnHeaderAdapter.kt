package com.adedom.tegreport.presentation.testfinal

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SingleRecyclerView

class ColumnHeaderAdapter : SingleRecyclerView<Unit>() {

    override fun getLayout(): Int = R.layout.item_final_column_header

    override fun View.onBindViewHolder(data: Unit?) {
    }

}
