package com.adedom.tegreport.presentation

import android.os.Bundle
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.FinalApi
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.coroutines.launch

class FinalActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
    }

    override fun onStart() {
        super.onStart()

        launch {
            tvFinal.text = FinalApi().callFetchFinal().toString()
        }
    }

}
