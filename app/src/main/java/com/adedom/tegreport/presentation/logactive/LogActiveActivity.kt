package com.adedom.tegreport.presentation.logactive

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_log_active.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class LogActiveActivity : BaseActivity() {

    private lateinit var mLogActiveAdapter: LogActiveAdapter
    private lateinit var mLogActiveFooterAdapter: LogActiveFooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_active)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        val logActiveColumnAdapter = LogActiveColumnAdapter()
        mLogActiveAdapter = LogActiveAdapter()
        mLogActiveFooterAdapter = LogActiveFooterAdapter()

        val adt = ConcatAdapter(
            logActiveColumnAdapter,
            mLogActiveAdapter,
            mLogActiveFooterAdapter,
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        fetchLogActive(null, null)

        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker().build()

        fab.setOnClickListener {
            dateRangePicker.show(supportFragmentManager, null)
        }

        dateRangePicker.addOnPositiveButtonClickListener {
            fetchLogActive(it.first, it.second?.plus(86_400_000)?.minus(1))
        }
    }

    private fun fetchLogActive(dateTimeIn: Long?, dateTimeOut: Long?) {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false

            val response = TegApi().callFetchLogActiveHistory(dateTimeIn, dateTimeOut)

            progressBar.isVisible = false
            recyclerView.isVisible = true

            mLogActiveAdapter.submitList(response.logActiveHistories)
            mLogActiveFooterAdapter.setData(response)
        }
    }

}
