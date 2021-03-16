package com.adedom.tegreport.presentation

import android.content.Intent
import android.os.Bundle
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.presentation.testfinal.FinalActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btFinal.setOnClickListener {
            Intent(baseContext, FinalActivity::class.java).also {
                startActivity(it)
            }
        }
    }

}
