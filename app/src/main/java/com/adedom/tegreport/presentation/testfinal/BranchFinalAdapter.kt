package com.adedom.tegreport.presentation.testfinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.adedom.tegreport.R
import com.adedom.tegreport.models.SubData
import kotlinx.android.synthetic.main.item_branch_final.view.*

class BranchFinalAdapter : RecyclerView.Adapter<BranchFinalAdapter.BranchFinalViewHolder>() {

    private val asyncListDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<SubData>() {
        override fun areItemsTheSame(oldItem: SubData, newItem: SubData): Boolean {
            return oldItem.subDataId == newItem.subDataId
        }

        override fun areContentsTheSame(oldItem: SubData, newItem: SubData): Boolean {
            return oldItem == newItem
        }
    })

    private val list: MutableList<SubData>
        get() = asyncListDiffer.currentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchFinalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_branch_final, parent, false)
        return BranchFinalViewHolder(view)
    }

    override fun onBindViewHolder(holder: BranchFinalViewHolder, position: Int) {
        holder.itemView.apply {
            val item = list[position]

            if (position > 0 && (item.date == list[position - 1].date)) {
                tvDate.visibility = View.INVISIBLE
            }

            tvDate.text = item.date
            tvTime.text = item.time
            tvItemA.text = item.itemA.toString()
            tvItemB.text = item.itemB.toString()
            tvItemC.text = item.itemC.toString()
            tvItemD.text = item.itemD.toString()
            tvTotalScore.text = item.totalScore.toString()
        }
    }

    override fun getItemCount(): Int = list.size

    fun submitList(list: List<SubData>) = asyncListDiffer.submitList(list)

    inner class BranchFinalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
