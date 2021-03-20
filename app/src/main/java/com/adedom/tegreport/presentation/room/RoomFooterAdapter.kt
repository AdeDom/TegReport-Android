package com.adedom.tegreport.presentation.room

import android.view.View
import com.adedom.teg.models.report.three.RoomHistoryResponse
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.ItemRecyclerView
import kotlinx.android.synthetic.main.item_room_footer.view.*

class RoomFooterAdapter : ItemRecyclerView<RoomHistoryResponse>() {

    override fun getLayout(): Int = R.layout.item_room_footer

    override fun View.onBindViewHolder() {
        tvRoomAll.text = "จำนวนห้องทั้งหมด ${getData()?.roomAll} ห้อง"
    }

}
