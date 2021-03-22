package com.adedom.tegreport.presentation.multicollection

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import com.adedom.tegreport.presentation.dateheader.DateHeaderAdapter
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_multi_collection.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class MultiCollectionActivity : BaseActivity() {

    private lateinit var mDateHeaderAdapter: DateHeaderAdapter
    private lateinit var mMultiCollectionColumnAdapter: MultiCollectionColumnAdapter
    private lateinit var mMultiCollectionDateAdapter: MultiCollectionDateAdapter
    private lateinit var mMultiCollectionFooterAdapter: MultiCollectionFooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_collection)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        mDateHeaderAdapter = DateHeaderAdapter()
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

        fetchMultiCollection(null, null)

        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker().build()

        fab.setOnClickListener {
            dateRangePicker.show(supportFragmentManager, null)
        }

        dateRangePicker.addOnPositiveButtonClickListener {
            fetchMultiCollection(it.first, it.second?.plus(86_400_000)?.minus(1))
        }
    }

    private fun fetchMultiCollection(begin: Long?, end: Long?) {
        launch {
            progressBar.visibility = View.VISIBLE
            recyclerView.visibility = View.INVISIBLE

            val response = TegApi().callFetchMultiCollectionHistory(begin, end)

            progressBar.visibility = View.INVISIBLE
            recyclerView.visibility = View.VISIBLE

            mDateHeaderAdapter.submitData(Pair(begin, end))
            mMultiCollectionColumnAdapter.submitData(Unit)
            mMultiCollectionDateAdapter.submitList(response.multiCollectionDates)
            mMultiCollectionFooterAdapter.submitData(response)
        }
    }

}
