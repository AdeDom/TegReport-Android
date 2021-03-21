package com.adedom.tegreport.presentation.itemcollection

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.ItemCollectionMode
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_item_collection_mode.view.*
import java.util.*

class ItemCollectionModeAdapter : SimpleRecyclerView<ItemCollectionMode>() {

    override fun getLayout(): Int = R.layout.item_item_collection_mode

    override fun View.onBindViewHolder(
        currentData: ItemCollectionMode,
        beforeData: ItemCollectionMode?
    ) {
        if (currentData.mode == beforeData?.mode) {
            tvMode.visibility = View.INVISIBLE
        }

        tvMode.text = currentData.mode?.capitalize(Locale.getDefault())
        tvItemAll.text = "ไอเทมทั้งหมด ${currentData.itemAll}"
        tvItemQtyAll.text = "จำนวนไอเทม ${currentData.itemQtyAll}"

        recyclerView.submitList(ItemCollectionItemAdapter(), currentData.itemCollectionItems)
    }

    override fun getAreItemsTheSame(
        oldItem: ItemCollectionMode,
        newItem: ItemCollectionMode
    ): Boolean {
        return oldItem.modeId == newItem.modeId
    }

}
