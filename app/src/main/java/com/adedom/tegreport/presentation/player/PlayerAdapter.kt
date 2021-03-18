package com.adedom.tegreport.presentation.player

import android.view.View
import com.adedom.teg.models.report.GamePlayerRanking
import com.adedom.teg.util.TegConstant
import com.adedom.tegreport.R
import com.adedom.tegreport.utils.SimpleRecyclerView
import com.adedom.tegreport.utils.loadCircle
import kotlinx.android.synthetic.main.item_player.view.*
import java.util.*

class PlayerAdapter : SimpleRecyclerView<GamePlayerRanking>() {

    override fun getLayout(): Int = R.layout.item_player

    override fun View.onBindViewHolder(
        currentData: GamePlayerRanking,
        beforeData: GamePlayerRanking?
    ) {
        tvPlayerId.text = currentData.playerId
        tvName.text = currentData.name
        tvBirthDate.text = currentData.birthDateString
        tvCurrentMode.text = currentData.currentMode?.capitalize(Locale.getDefault())
        tvDateTimeCreated.text = currentData.dateTimeCreated
        tvLevel.text = currentData.level.toString()

        // image
        if (currentData.image.isNullOrBlank()) {
            if (currentData.gender == TegConstant.GENDER_MALE) {
                ivImage.setImageResource(R.drawable.ic_image_profile_male)
            } else {
                ivImage.setImageResource(R.drawable.ic_image_profile_female)
            }
        } else {
            ivImage.loadCircle(currentData.image)
        }

        // gender
        if (currentData.gender == TegConstant.GENDER_MALE) {
            icGender.setImageResource(R.drawable.ic_male)
        } else {
            icGender.setImageResource(R.drawable.ic_female)
        }

        // state
        if (currentData.state == TegConstant.STATE_ONLINE) {
            ivState.setImageResource(R.drawable.shape_oval_green)
        } else {
            ivState.setImageResource(R.drawable.shape_oval_red)
        }
    }

    override fun getAreItemsTheSame(
        oldItem: GamePlayerRanking,
        newItem: GamePlayerRanking
    ): Boolean {
        return oldItem.playerId == newItem.playerId
    }

}
