package com.adedom.tegreport.presentation.itemcollection

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.Collection
import com.adedom.tegreport.utils.SimpleRecyclerView
import kotlinx.android.synthetic.main.item_item_collection_collection.view.*

class ItemCollectionCollectionAdapter : SimpleRecyclerView<Collection>() {

    override fun getLayout(): Int = R.layout.item_item_collection_collection

    override fun View.onBindViewHolder(currentData: Collection, beforeData: Collection?) {
        tvDate.text = currentData.date
        tvTime.text = currentData.time
    }

    override fun getAreItemsTheSame(oldItem: Collection, newItem: Collection): Boolean {
        return oldItem.collectionId == newItem.collectionId
    }

}
