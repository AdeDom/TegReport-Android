package com.adedom.tegreport.presentation.logactive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adedom.tegreport.R
import kotlinx.android.synthetic.main.toolbar.*

class LogActiveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_active)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

    }

}
