package com.adedom.tegreport.presentation.testfinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.adedom.tegreport.R
import com.adedom.tegreport.models.Final
import kotlinx.android.synthetic.main.item_final.view.*

class FinalAdapter : RecyclerView.Adapter<FinalAdapter.FinalViewHolder>() {

    private val asyncListDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Final>() {
        override fun areItemsTheSame(oldItem: Final, newItem: Final): Boolean {
            return oldItem.playerId == newItem.playerId
        }

        override fun areContentsTheSame(oldItem: Final, newItem: Final): Boolean {
            return oldItem == newItem
        }
    })

    private val list: MutableList<Final>
        get() = asyncListDiffer.currentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_final, parent, false)
        return FinalViewHolder(view)
    }

    override fun onBindViewHolder(holder: FinalViewHolder, position: Int) {
        holder.itemView.apply {
            val item = list[position]

            tvPlayerId.text = item.playerId
            tvName.text = item.name
            tvTotalDate.text = "รวม ${item.totalDate} วัน"
            tvSubTotalScore.text = "รวมคะแนน ${item.subTotalScore}"
        }
    }

    override fun getItemCount(): Int = list.size

    fun submitList(list: List<Final>) = asyncListDiffer.submitList(list)

    inner class FinalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
