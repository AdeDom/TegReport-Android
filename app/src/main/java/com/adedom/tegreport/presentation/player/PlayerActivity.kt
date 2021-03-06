package com.adedom.tegreport.presentation.player

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import kotlinx.android.synthetic.main.activity_player.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class PlayerActivity : BaseActivity() {

    private lateinit var mPlayerHeaderAdapter: PlayerHeaderAdapter
    private lateinit var mPlayerColumnAdapter: PlayerColumnAdapter
    private lateinit var mPlayerAdapter: PlayerAdapter
    private lateinit var mPlayerFooterAdapter: PlayerFooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        mPlayerHeaderAdapter = PlayerHeaderAdapter()
        mPlayerColumnAdapter = PlayerColumnAdapter()
        mPlayerAdapter = PlayerAdapter()
        mPlayerFooterAdapter = PlayerFooterAdapter()

        val adt = ConcatAdapter(
            mPlayerHeaderAdapter,
            mPlayerColumnAdapter,
            mPlayerAdapter,
            mPlayerFooterAdapter,
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        fetchPlayer(null, null)

        mPlayerHeaderAdapter.setOnClickListener {
            fetchPlayer(it.first, it.second)
        }
    }

    private fun fetchPlayer(begin: Int?, end: Int?) {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false

            val response = TegApi().callFetchGamePlayerRankings(begin, end)

            progressBar.isVisible = false
            recyclerView.isVisible = true

            mPlayerHeaderAdapter.submitData(Unit)
            mPlayerColumnAdapter.submitData(Unit)
            mPlayerAdapter.submitList(response.gamePlayerRankings)
            mPlayerFooterAdapter.submitData(response)
        }
    }

}
