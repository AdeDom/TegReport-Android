package com.adedom.tegreport.presentation.testfinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.adedom.tegreport.R
import com.adedom.tegreport.models.Data
import kotlinx.android.synthetic.main.item_sub_final.view.*

class SubFinalAdapter : RecyclerView.Adapter<SubFinalAdapter.SubFinalViewHolder>() {

    private val asyncListDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.dataId == newItem.dataId
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    })

    private val list: MutableList<Data>
        get() = asyncListDiffer.currentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubFinalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sub_final, parent, false)
        return SubFinalViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubFinalViewHolder, position: Int) {
        holder.itemView.apply {
            val item = list[position]

            tvBranchTotalScore.text = "รวมคะแนน ${item.branchTotalScore}"
        }
    }

    override fun getItemCount(): Int = list.size

    fun submitList(list: List<Data>) = asyncListDiffer.submitList(list)

    inner class SubFinalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
