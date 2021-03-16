package com.adedom.tegreport.presentation.testfinal

import android.os.Bundle
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.FinalApi
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.coroutines.launch

class FinalActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        launch {
            val response = FinalApi().callFetchFinal()

            recyclerView.submitList(FinalAdapter(), response.finals)
            tvGrandTotalPeople.text = "รวมจำนวนผู้เล่น ${response.grandTotalPeople} คน"
            tvGrandTotalScore.text = "รวมคะแนน ${response.grandTotalScore}"
        }
    }

}
