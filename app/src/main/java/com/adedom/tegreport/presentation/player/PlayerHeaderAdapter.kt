package com.adedom.tegreport.presentation.player

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.ItemRecyclerView
import kotlinx.android.synthetic.main.item_player_header.view.*

class PlayerHeaderAdapter : ItemRecyclerView<Pair<Int?, Int?>>() {

    override fun getLayout(): Int = R.layout.item_player_header

    override fun View.onBindViewHolder() {
        val levelHeader = if (getData()?.first == null && getData()?.second == null) {
            "ตั้งแต่เลเวล - ถึงเลเวล -"
        } else {
            "ตั้งแต่เลเวล ${getData()?.first} ถึงเลเวล ${getData()?.second}"
        }
        tvLevelHeader.text = levelHeader
    }

}
