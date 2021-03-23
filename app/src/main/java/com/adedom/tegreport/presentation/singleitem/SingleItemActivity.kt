package com.adedom.tegreport.presentation.singleitem

import android.os.Bundle
import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_single_item.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class SingleItemActivity : BaseActivity() {

    private lateinit var mSingleItemAdapter: SingleItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_item)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        mSingleItemAdapter = SingleItemAdapter()

        expandableListView.setAdapter(mSingleItemAdapter)

        fetchSingleItem(null, null)

        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker().build()

        fab.setOnClickListener {
            dateRangePicker.show(supportFragmentManager, null)
        }

        dateRangePicker.addOnPositiveButtonClickListener {
            fetchSingleItem(it.first, it.second?.plus(86_400_000)?.minus(1))
        }
    }

    private fun fetchSingleItem(begin: Long?, end: Long?) {
        launch {
            progressBar.visibility = View.VISIBLE
            expandableListView.visibility = View.INVISIBLE
            tvDateAll.visibility = View.INVISIBLE

            val response = TegApi().callFetchSingleItemHistory(begin, end)

            expandableListView.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE
            tvDateAll.visibility = View.VISIBLE

            tvDateAll.text = "รวมทั้งหมด ${response.dateAll} วัน"
            mSingleItemAdapter.setList(response.singleItemDates)
        }
    }

}
