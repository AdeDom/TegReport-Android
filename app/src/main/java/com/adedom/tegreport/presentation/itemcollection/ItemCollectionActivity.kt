package com.adedom.tegreport.presentation.itemcollection

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import kotlinx.android.synthetic.main.activity_item_collection.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class ItemCollectionActivity : BaseActivity() {

    private lateinit var mItemCollectionPlayerAdapter: ItemCollectionPlayerAdapter
    private lateinit var mItemCollectionFooterAdapter: ItemCollectionFooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_collection)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        mItemCollectionPlayerAdapter = ItemCollectionPlayerAdapter()
        mItemCollectionFooterAdapter = ItemCollectionFooterAdapter()

        val adt = ConcatAdapter(
            mItemCollectionPlayerAdapter,
            mItemCollectionFooterAdapter,
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        fetchItemCollection()
    }

    private fun fetchItemCollection() {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false

            val response = TegApi().callFetchItemCollectionHistory()

            progressBar.isVisible = false
            recyclerView.isVisible = true

            mItemCollectionPlayerAdapter.submitList(response.itemCollectionPlayers)
            mItemCollectionFooterAdapter.submitData(response)
        }
    }

}
