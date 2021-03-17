package com.adedom.tegreport.presentation.singleitem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adedom.tegreport.R
import kotlinx.android.synthetic.main.toolbar.*

class SingleItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_item)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

    }

}
