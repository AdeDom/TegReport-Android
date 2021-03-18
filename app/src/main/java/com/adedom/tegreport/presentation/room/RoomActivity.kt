package com.adedom.tegreport.presentation.room

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.MockyApi
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class RoomActivity : BaseActivity() {

    private lateinit var mRoomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        mRoomAdapter = RoomAdapter()

        val adt = ConcatAdapter(
            mRoomAdapter,
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        fetchRooms()

    }

    private fun fetchRooms() {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false

            val response = MockyApi().callFetchRooms()

            progressBar.isVisible = false
            recyclerView.isVisible = true

            mRoomAdapter.submitList(response.rooms)
        }
    }

}
