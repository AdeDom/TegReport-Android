package com.adedom.tegreport.presentation.itemcollection

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.models.Player
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.item_item_collection_player.view.*

class ItemCollectionPlayerAdapter : SimpleRecyclerView<Player>() {

    override fun getLayout(): Int = R.layout.item_item_collection_player

    override fun View.onBindViewHolder(currentData: Player, beforeData: Player?) {
        tvPlayerId.text = currentData.playerId
        tvName.text = currentData.name
        tvModeAll.text = "โหมดทั้งหมด ${currentData.modeAll}"

        recyclerView.submitList(ItemCollectionModeAdapter(), currentData.modes)
    }

    override fun getAreItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.playerId == newItem.playerId
    }

}
