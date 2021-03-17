package com.adedom.tegreport.presentation.itemcollection

import android.os.Bundle
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class ItemCollectionActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_collection)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

    }

}
