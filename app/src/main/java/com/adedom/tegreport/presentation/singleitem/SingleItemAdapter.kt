package com.adedom.tegreport.presentation.singleitem

import android.view.View
import com.adedom.teg.models.report.six.SingleItemDate
import com.adedom.teg.models.report.six.SingleItemTime
import com.adedom.teg.util.TegConstant
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleExpandableListAdapter
import kotlinx.android.synthetic.main.item_single_item_detail.view.*
import kotlinx.android.synthetic.main.item_single_item_main.view.*

class SingleItemAdapter : SimpleExpandableListAdapter<SingleItemDate, SingleItemTime>() {

    override fun getPropertyDetailList(item: SingleItemDate): List<SingleItemTime> {
        return item.singleItemTimes
    }

    override fun onCreateViewHolderMain(): Int = R.layout.item_single_item_main

    override fun View.onBindViewHolderMain(item: SingleItemDate) {
        tvDate.text = item.date
    }

    override fun onCreateViewHolderDetail(): Int = R.layout.item_single_item_detail

    override fun View.onBindViewHolderDetail(item: SingleItemTime) {
        tvTime.text = item.time
        tvPlayerId.text = item.playerId ?: "ผู้เล่นยังไม่ได้เก็บไอเทมนี้"
        tvName.text = item.name
        tvDateTimeUpdated.text = item.dateTimeUpdated

        when (item.itemTypeId) {
            1 -> ivItemTypeId.setImageResource(R.drawable.ic_egg)
            2 -> ivItemTypeId.setImageResource(R.drawable.ic_mystery_box)
            3 -> ivItemTypeId.setImageResource(R.drawable.ic_mystery_item)
            4 -> ivItemTypeId.setImageResource(R.drawable.ic_egg_bonus)
        }

        if (item.status == TegConstant.SINGLE_ITEM_STATUS_ON) {
            ivStatus.setImageResource(R.drawable.shape_oval_green)
        } else {
            ivStatus.setImageResource(R.drawable.shape_oval_red)
        }
    }

}
