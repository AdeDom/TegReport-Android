package com.adedom.tegreport.presentation.logactive

import android.os.Bundle
import androidx.core.view.isVisible
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.MockyApi
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.activity_log_active.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class LogActiveActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_active)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        fetchLogActive()

    }

    private fun fetchLogActive() {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false

            val response = MockyApi().callFetchLogActive()

            progressBar.isVisible = false
            recyclerView.isVisible = true

            recyclerView.submitList(LogActiveAdapter(), response.logActives)

        }
    }

}
