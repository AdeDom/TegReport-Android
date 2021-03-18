package com.adedom.tegreport.presentation.logactive

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.MockyApi
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

        fetchLogActive()

    }

    private fun fetchLogActive() {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false

            val response = MockyApi().callFetchLogActive()

            progressBar.isVisible = false
            recyclerView.isVisible = true

            mLogActiveAdapter.submitList(response.logActives)
            mLogActiveFooterAdapter.setData(response)
        }
    }

}
