package com.adedom.tegreport.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : AppCompatActivity(), CoroutineScope {

    private val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, err ->
        Toast.makeText(baseContext, "${err.message}", Toast.LENGTH_LONG).show()
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main + exceptionHandler

    override fun onDestroy() {
        coroutineContext.cancel()
        super.onDestroy()
    }

}
