package com.adedom.tegreport.presentation.player

import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.ItemRecyclerView
import kotlinx.android.synthetic.main.item_player_header.view.*

class PlayerHeaderAdapter : ItemRecyclerView<Unit>() {

    private var listener: ((Pair<Int, Int>) -> Unit)? = null

    override fun getLayout(): Int = R.layout.item_player_header

    override fun View.onBindViewHolder() {
        btSearch.setOnClickListener {
            val begin = etBegin.text.toString().trim().toInt()
            val end = etEnd.text.toString().trim().toInt()
            listener?.invoke(Pair(begin, end))
        }
    }

    fun setOnClickListener(listener: (Pair<Int, Int>) -> Unit) {
        this.listener = listener
    }

}
