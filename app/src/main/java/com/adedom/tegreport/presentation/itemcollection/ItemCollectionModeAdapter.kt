package com.adedom.tegreport.presentation.itemcollection

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.Mode
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_item_collection_mode.view.*

class ItemCollectionModeAdapter : SimpleRecyclerView<Mode>() {

    override fun getLayout(): Int = R.layout.item_item_collection_mode

    override fun View.onBindViewHolder(currentData: Mode, beforeData: Mode?) {
        tvMode.text = currentData.mode
        tvItemAll.text = "ไอเทมทั้งหมด ${currentData.itemAll}"
        tvItemQtyAll.text = "จำนวนไอเทมทั้งสิ้น ${currentData.itemQtyAll}"

        recyclerView.submitList(ItemCollectionItemAdapter(), currentData.items)
    }

    override fun getAreItemsTheSame(oldItem: Mode, newItem: Mode): Boolean {
        return oldItem.modeId == newItem.modeId
    }

}
