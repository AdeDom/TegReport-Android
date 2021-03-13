package com.adedom.tegreport.presentation.testfinal

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.FinalApi
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.coroutines.launch

class FinalActivity : BaseActivity() {

    private val mAdapter by lazy { FinalAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = mAdapter
        }

        launch {
            val response = FinalApi().callFetchFinal()

            mAdapter.submitList(response.finals)
            tvGrandTotalPeople.text = "รวมจำนวนผู้เล่น ${response.grandTotalPeople} คน"
            tvGrandTotalScore.text = "รวมคะแนน ${response.grandTotalScore}"
        }
    }

}
