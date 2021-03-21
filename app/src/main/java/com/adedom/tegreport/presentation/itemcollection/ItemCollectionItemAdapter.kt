package com.adedom.tegreport.presentation.itemcollection

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.Item
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_item_collection_item.view.*

class ItemCollectionItemAdapter : SimpleRecyclerView<Item>() {

    override fun getLayout(): Int = R.layout.item_item_collection_item

    override fun View.onBindViewHolder(currentData: Item, beforeData: Item?) {
        tvItemType.text = currentData.itemType
        tvCollectionAll.text = "คอลเลคชัน ${currentData.collectionAll}"
        tvItemQty.text = "จำนวนไอเทม ${currentData.itemQty}"

        recyclerView.submitList(ItemCollectionCollectionAdapter(), currentData.collections)
    }

    override fun getAreItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.itemId == newItem.itemId
    }

}
