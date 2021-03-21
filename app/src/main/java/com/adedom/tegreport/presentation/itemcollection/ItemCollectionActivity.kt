package com.adedom.tegreport.presentation.itemcollection

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import com.adedom.tegreport.presentation.dateheader.DateHeaderAdapter
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_item_collection.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class ItemCollectionActivity : BaseActivity() {

    private lateinit var mDateHeaderAdapter: DateHeaderAdapter
    private lateinit var mItemCollectionColumnAdapter: ItemCollectionColumnAdapter
    private lateinit var mItemCollectionPlayerAdapter: ItemCollectionPlayerAdapter
    private lateinit var mItemCollectionFooterAdapter: ItemCollectionFooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_collection)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        mDateHeaderAdapter = DateHeaderAdapter()
        mItemCollectionColumnAdapter = ItemCollectionColumnAdapter()
        mItemCollectionPlayerAdapter = ItemCollectionPlayerAdapter()
        mItemCollectionFooterAdapter = ItemCollectionFooterAdapter()

        val adt = ConcatAdapter(
            mDateHeaderAdapter,
            mItemCollectionColumnAdapter,
            mItemCollectionPlayerAdapter,
            mItemCollectionFooterAdapter,
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        fetchItemCollection(null, null)

        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker().build()

        fab.setOnClickListener {
            dateRangePicker.show(supportFragmentManager, null)
        }

        dateRangePicker.addOnPositiveButtonClickListener {
            fetchItemCollection(it.first, it.second?.plus(86_400_000)?.minus(1))
        }
    }

    private fun fetchItemCollection(begin: Long?, end: Long?) {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false

            val response = TegApi().callFetchItemCollectionHistory(begin, end)

            progressBar.isVisible = false
            recyclerView.isVisible = true

            mDateHeaderAdapter.submitData(Pair(begin, end))
            mItemCollectionColumnAdapter.submitData(Unit)
            mItemCollectionPlayerAdapter.submitList(response.itemCollectionPlayers)
            mItemCollectionFooterAdapter.submitData(response)
        }
    }

}
