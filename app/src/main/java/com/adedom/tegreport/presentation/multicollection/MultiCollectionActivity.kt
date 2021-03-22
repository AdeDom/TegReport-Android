package com.adedom.tegreport.presentation.multicollection

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.MockyApi
import kotlinx.android.synthetic.main.activity_multi_collection.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class MultiCollectionActivity : BaseActivity() {

    private lateinit var mMultiCollectionColumnAdapter: MultiCollectionColumnAdapter
    private lateinit var mMultiCollectionDateAdapter: MultiCollectionDateAdapter
    private lateinit var mMultiCollectionFooterAdapter: MultiCollectionFooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_collection)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        mMultiCollectionColumnAdapter = MultiCollectionColumnAdapter()
        mMultiCollectionDateAdapter = MultiCollectionDateAdapter()
        mMultiCollectionFooterAdapter = MultiCollectionFooterAdapter()

        val adt = ConcatAdapter(
            mMultiCollectionColumnAdapter,
            mMultiCollectionDateAdapter,
            mMultiCollectionFooterAdapter,
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        fetchMultiCollection()
    }

    private fun fetchMultiCollection() {
        launch {
            progressBar.visibility = View.VISIBLE
            recyclerView.visibility = View.INVISIBLE

            val response = MockyApi().callFetchMultiCollection()
            Log.d(TAG, "fetchMultiCollection: $response")

            progressBar.visibility = View.INVISIBLE
            recyclerView.visibility = View.VISIBLE

            mMultiCollectionColumnAdapter.submitData(Unit)
            mMultiCollectionDateAdapter.submitList(response.multiCollectionDates)
            mMultiCollectionFooterAdapter.submitData(response)
        }
    }

    companion object {
        private const val TAG = "MultiCollectionActivity"
    }

}
