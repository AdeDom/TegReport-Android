package com.adedom.tegreport.presentation.player

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.MockyApi
import kotlinx.android.synthetic.main.activity_player.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class PlayerActivity : BaseActivity() {

    private lateinit var mPlayerAdapter: PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        val playerColumnAdapter = PlayerColumnAdapter()
        mPlayerAdapter = PlayerAdapter()

        val adt = ConcatAdapter(
            playerColumnAdapter,
            mPlayerAdapter,
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        fetchPlayer()

    }

    private fun fetchPlayer() {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false

            val response = MockyApi().callFetchPlayer()

            progressBar.isVisible = false
            recyclerView.isVisible = true

            mPlayerAdapter.submitList(response.gamePlayerRankings)

        }
    }

}
