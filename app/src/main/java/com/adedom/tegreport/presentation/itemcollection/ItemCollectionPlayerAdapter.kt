package com.adedom.tegreport.presentation.itemcollection

import android.view.View
import com.adedom.teg.models.report.four.ItemCollectionPlayer
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_item_collection_player.view.*

class ItemCollectionPlayerAdapter : SimpleRecyclerView<ItemCollectionPlayer>() {

    override fun getLayout(): Int = R.layout.item_item_collection_player

    override fun View.onBindViewHolder(
        currentData: ItemCollectionPlayer,
        beforeData: ItemCollectionPlayer?
    ) {
        tvPlayerId.text = currentData.playerId
        tvName.text = currentData.name
        tvModeAll.text = "โหมดทั้งหมด ${currentData.modeAll}"

        recyclerView.submitList(ItemCollectionModeAdapter(), currentData.itemCollectionModes)
    }

    override fun getAreItemsTheSame(
        oldItem: ItemCollectionPlayer,
        newItem: ItemCollectionPlayer
    ): Boolean {
        return oldItem.playerId == newItem.playerId
    }

}
