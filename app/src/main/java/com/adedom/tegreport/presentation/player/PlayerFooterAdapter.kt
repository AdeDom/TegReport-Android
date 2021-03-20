package com.adedom.tegreport.presentation.player

import android.view.View
import com.adedom.teg.models.report.GamePlayerRankingsResponse
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SingleRecyclerView
import kotlinx.android.synthetic.main.item_player_footer.view.*

class PlayerFooterAdapter : SingleRecyclerView<GamePlayerRankingsResponse>() {

    override fun getLayout(): Int = R.layout.item_player_footer

    override fun View.onBindViewHolder(data: GamePlayerRankingsResponse?) {
        tvPeopleAll.text = "${data?.peopleAll} คน"
        tvGenderMale.text = "ชาย ${data?.genderCount?.male} คน"
        tvGenderFemale.text = "หญิง ${data?.genderCount?.female} คน"
        tvStateOnline.text = "ออนไลน์ ${data?.stateCount?.online} คน"
        tvStateOffline.text = "ออฟไลน์ ${data?.stateCount?.offline} คน"
        tvModeMain.text = "Main ${data?.modeCount?.main} คน"
        tvModeSingle.text = "Single ${data?.modeCount?.single} คน"
        tvModeMulti.text = "Multi ${data?.modeCount?.multi} คน"
    }

}
