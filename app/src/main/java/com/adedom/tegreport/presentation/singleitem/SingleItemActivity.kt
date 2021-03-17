package com.adedom.tegreport.presentation.singleitem

import android.os.Bundle
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class SingleItemActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_item)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

    }

}
