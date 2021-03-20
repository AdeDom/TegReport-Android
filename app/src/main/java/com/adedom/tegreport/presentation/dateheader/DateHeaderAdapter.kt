package com.adedom.tegreport.presentation.dateheader

import android.util.Log
import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.ItemRecyclerView
import kotlinx.android.synthetic.main.item_date_header.view.*
import java.text.SimpleDateFormat
import java.util.*

class DateHeaderAdapter : ItemRecyclerView<Pair<Long?, Long?>>() {

    override fun getLayout(): Int = R.layout.item_date_header

    override fun View.onBindViewHolder() {
        val item = getData()
        Log.d(TAG, "onBindViewHolder: ${item?.first}, ${item?.second}")

        val sdf = SimpleDateFormat("d/M/yy", Locale.getDefault())
        if (item?.first == null && item?.second == null) {
            tvDateBeginAndEnd.text = "ตั้งแต่วันที่ - ถึงวันที่ - "
        } else {
            tvDateBeginAndEnd.text =
                "ตั้งแต่วันที่ ${sdf.format(item?.first)} ถึงวันที่ ${sdf.format(item?.second)}"
        }
    }

    companion object {
        private const val TAG = "DateHeaderAdapter"
    }

}
