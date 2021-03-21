package com.adedom.tegreport.presentation.itemcollection

import android.view.View
import com.adedom.teg.models.report.four.ItemCollectionHistoryResponse
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SingleRecyclerView
import com.adedom.tegreport.utils.tegFormat
import kotlinx.android.synthetic.main.item_item_collection_footer.view.*

class ItemCollectionFooterAdapter : SingleRecyclerView<ItemCollectionHistoryResponse>() {

    override fun getLayout(): Int = R.layout.item_item_collection_footer

    override fun View.onBindViewHolder(data: ItemCollectionHistoryResponse?) {
        tvItemAll.text = "จำนวนไอเทมทั้งหมด ${data?.itemAll.tegFormat()} ชิ้น"
        tvPlayerAll.text = "ผู้เล่นทั้งหมดมีจำนวน ${data?.playerAll} คน"
    }

}
