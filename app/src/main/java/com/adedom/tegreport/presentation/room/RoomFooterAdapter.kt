package com.adedom.tegreport.presentation.room

import android.view.View
import com.adedom.teg.models.report.three.RoomHistoryResponse
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SingleRecyclerView
import kotlinx.android.synthetic.main.item_room_footer.view.*

class RoomFooterAdapter : SingleRecyclerView<RoomHistoryResponse>() {

    override fun getLayout(): Int = R.layout.item_room_footer

    override fun View.onBindViewHolder(data: RoomHistoryResponse?) {
        tvRoomAll.text = "จำนวนห้องทั้งหมด ${data?.roomAll} ห้อง"
    }

}
