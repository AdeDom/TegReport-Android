package com.adedom.tegreport.presentation.itemcollection

import android.view.View
import com.adedom.teg.models.report.four.ItemCollectionItem
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import kotlinx.android.synthetic.main.item_item_collection_item.view.*

class ItemCollectionItemAdapter : SimpleRecyclerView<ItemCollectionItem>() {

    override fun getLayout(): Int = R.layout.item_item_collection_item

    override fun View.onBindViewHolder(
        currentData: ItemCollectionItem,
        beforeData: ItemCollectionItem?
    ) {
        if (currentData.date == beforeData?.date) {
            tvDate.visibility = View.INVISIBLE
        }

        if (currentData.time == beforeData?.time) {
            tvTime.visibility = View.INVISIBLE
        }

        if (currentData.itemId == beforeData?.itemId) {
            ivItemId.visibility = View.INVISIBLE
        }

        tvQty.text = currentData.qty.toString()
        tvDate.text = currentData.date
        tvTime.text = currentData.time

        when (currentData.itemId) {
            1 -> ivItemId.setImageResource(R.drawable.ic_egg_i)
            2 -> ivItemId.setImageResource(R.drawable.ic_egg_ii)
            3 -> ivItemId.setImageResource(R.drawable.ic_egg_iii)
            999 -> ivItemId.setImageResource(R.drawable.ic_egg)
        }
    }

    override fun getAreItemsTheSame(
        oldItem: ItemCollectionItem,
        newItem: ItemCollectionItem
    ): Boolean {
        return oldItem.collectionId == newItem.collectionId
    }

}
