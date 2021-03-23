package com.adedom.tegreport.presentation.singleitem

import android.os.Bundle
import android.view.View
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.MockyApi
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

        fetchSingleItem()
    }

    private fun fetchSingleItem() {
        launch {
            progressBar.visibility = View.VISIBLE
            expandableListView.visibility = View.INVISIBLE

            val response = MockyApi().callFetchSingleItemHistory()

            expandableListView.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE

            mSingleItemAdapter.setList(response.singleItemDates)
        }
    }

}
