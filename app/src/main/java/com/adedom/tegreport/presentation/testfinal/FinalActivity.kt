package com.adedom.tegreport.presentation.testfinal

import android.os.Bundle
import android.util.Log
import androidx.core.util.Pair
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import com.adedom.tegreport.presentation.dateheader.DateHeaderAdapter
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch
import java.util.*

class FinalActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker().apply {
            setSelection(Pair(Date().time, Date().time))
        }.build()

        fab.setOnClickListener {
            dateRangePicker.show(supportFragmentManager, null)
        }

        dateRangePicker.addOnPositiveButtonClickListener {
            fetchFinal(it.first, it.second?.plus(86_400_000)?.minus(1))
        }

        fetchFinal(null, null)
    }

    private fun fetchFinal(begin: Long?, end: Long?) {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false
            fab.isVisible = false

            val response = TegApi().callFetchTestFinalPantip(begin, end)

            progressBar.isVisible = false
            recyclerView.isVisible = true
            fab.isVisible = true

            val dateHeadAdapter = DateHeaderAdapter()
            val columnHeaderAdapter = ColumnHeaderAdapter()
            val finalAdapter = FinalAdapter()
            val resultFooterAdapter = ResultFooterAdapter()

            val adt = ConcatAdapter(
                dateHeadAdapter,
                columnHeaderAdapter,
                finalAdapter,
                resultFooterAdapter,
            )

            recyclerView.apply {
                layoutManager = LinearLayoutManager(baseContext)
                adapter = adt
            }

            dateHeadAdapter.submitData(kotlin.Pair(begin, end))
            finalAdapter.submitList(response.finals)
            resultFooterAdapter.submitData(
                kotlin.Pair(response.grandTotalPeople, response.grandTotalScore)
            )

            Log.d(TAG, "onCreate: $response")
        }
    }

    companion object {
        private const val TAG = "FinalActivity"
    }

}
