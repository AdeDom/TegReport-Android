package com.adedom.tegreport.presentation.testfinal

import android.os.Bundle
import android.util.Log
import androidx.core.util.Pair
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.FinalApi
import com.adedom.tegreport.utils.submitList
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.coroutines.launch
import java.util.*

class FinalActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker().apply {
            setSelection(Pair(Date().time, Date().time))
        }.build()

        fab.setOnClickListener {
            dateRangePicker.show(supportFragmentManager, null)
        }

        dateRangePicker.addOnPositiveButtonClickListener {
            val dateBeginAndEnd = "${it.first}, ${it.second}"
            tvDateBeginAndEnd.text = dateBeginAndEnd
        }

        fetchFinal()
    }

    private fun fetchFinal() {
        launch {
            val response = FinalApi().callFetchFinal()

            recyclerView.submitList(FinalAdapter(), response.finals)
            tvGrandTotalPeople.text = "รวมจำนวนผู้เล่น ${response.grandTotalPeople} คน"
            tvGrandTotalScore.text = "รวมคะแนน ${response.grandTotalScore}"

            Log.d(TAG, "onCreate: $response")
        }
    }

    companion object {
        private const val TAG = "FinalActivity"
    }

}
