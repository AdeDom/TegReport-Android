package com.adedom.tegreport.presentation.multicollection

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.MultiCollectionHistoryResponse
import com.adedom.tegreport.utils.SingleRecyclerView
import kotlinx.android.synthetic.main.item_multi_collection_footer.view.*

class MultiCollectionFooterAdapter : SingleRecyclerView<MultiCollectionHistoryResponse>() {

    override fun getLayout(): Int = R.layout.item_multi_collection_footer

    override fun View.onBindViewHolder(data: MultiCollectionHistoryResponse?) {
        tvDateAll.text = "จำนวนวันทั้งหมด ${data?.dateAll} วัน"
    }

}
