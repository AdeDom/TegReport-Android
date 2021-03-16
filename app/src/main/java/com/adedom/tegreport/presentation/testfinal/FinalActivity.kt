package com.adedom.tegreport.presentation.testfinal

import android.os.Bundle
import android.util.Log
import androidx.core.util.Pair
import androidx.core.view.isVisible
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import com.adedom.tegreport.utils.submitList
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
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
            fetchFinal(it.first, it.second)
        }

        fetchFinal(1609459200000, 1615852800000)
    }

    private fun fetchFinal(begin: Long?, end: Long?) {
        launch {
            progressBar.isVisible = true
            tvDateBeginAndEnd.isVisible = false
            recyclerView.isVisible = false
            tvGrandTotalPeople.isVisible = false
            tvGrandTotalScore.isVisible = false
            view.isVisible = false
            view2.isVisible = false
            fab.isVisible = false

            val response = TegApi().callFetchTestFinalPantip(begin, end)

            progressBar.isVisible = false
            tvDateBeginAndEnd.isVisible = true
            recyclerView.isVisible = true
            tvGrandTotalPeople.isVisible = true
            tvGrandTotalScore.isVisible = true
            view.isVisible = true
            view2.isVisible = true
            fab.isVisible = true

            val sdf = SimpleDateFormat("d/M/yy", Locale.getDefault())
            tvDateBeginAndEnd.text =
                "ตั้งแต่วันที่ ${sdf.format(begin)} ถึงวันที่ ${sdf.format(end)}"

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
