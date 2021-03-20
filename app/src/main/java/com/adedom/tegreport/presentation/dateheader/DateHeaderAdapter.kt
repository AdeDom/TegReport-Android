package com.adedom.tegreport.presentation.dateheader

import android.util.Log
import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SingleRecyclerView
import kotlinx.android.synthetic.main.item_date_header.view.*
import java.text.SimpleDateFormat
import java.util.*

class DateHeaderAdapter : SingleRecyclerView<Pair<Long?, Long?>>() {

    override fun getLayout(): Int = R.layout.item_date_header

    override fun View.onBindViewHolder(data: Pair<Long?, Long?>?) {
        Log.d(TAG, "onBindViewHolder: ${data?.first}, ${data?.second}")

        val sdf = SimpleDateFormat("d/M/yy", Locale.getDefault())
        if (data?.first == null && data?.second == null) {
            tvDateBeginAndEnd.text = "ตั้งแต่วันที่ - ถึงวันที่ - "
        } else {
            tvDateBeginAndEnd.text =
                "ตั้งแต่วันที่ ${sdf.format(data?.first)} ถึงวันที่ ${sdf.format(data?.second)}"
        }
    }

    companion object {
        private const val TAG = "DateHeaderAdapter"
    }

}
