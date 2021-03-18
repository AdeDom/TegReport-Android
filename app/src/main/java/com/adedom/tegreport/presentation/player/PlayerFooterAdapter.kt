package com.adedom.tegreport.presentation.player

import android.view.View
import com.adedom.teg.models.report.GamePlayerRankingsResponse
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.ItemRecyclerView
import kotlinx.android.synthetic.main.item_player_footer.view.*

class PlayerFooterAdapter : ItemRecyclerView<GamePlayerRankingsResponse>() {

    override fun getLayout(): Int = R.layout.item_player_footer

    override fun View.onBindViewHolder() {
        val item = getData()

        tvPeopleAll.text = "${item?.peopleAll} คน"
        tvGenderMale.text = "ชาย ${item?.genderCount?.male} คน"
        tvGenderFemale.text = "หญิง ${item?.genderCount?.female} คน"
        tvStateOnline.text = "ออนไลน์ ${item?.stateCount?.online} คน"
        tvStateOffline.text = "ออฟไลน์ ${item?.stateCount?.offline} คน"
        tvModeMain.text = "Main ${item?.modeCount?.main} คน"
        tvModeSingle.text = "Single ${item?.modeCount?.single} คน"
        tvModeMulti.text = "Multi ${item?.modeCount?.multi} คน"
    }

}
