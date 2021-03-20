package com.adedom.tegreport.presentation.room

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import com.adedom.tegreport.presentation.dateheader.DateHeaderAdapter
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.launch

class RoomActivity : BaseActivity() {

    private lateinit var mDateHeaderAdapter: DateHeaderAdapter
    private lateinit var mRoomColumnAdapter: RoomColumnAdapter
    private lateinit var mRoomAdapter: RoomAdapter
    private lateinit var mRoomFooterAdapter: RoomFooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val title = intent.getStringExtra("report")
        toolbar.title = title
        setSupportActionBar(toolbar)

        mDateHeaderAdapter = DateHeaderAdapter()
        mRoomColumnAdapter = RoomColumnAdapter()
        mRoomAdapter = RoomAdapter()
        mRoomFooterAdapter = RoomFooterAdapter()

        val adt = ConcatAdapter(
            mDateHeaderAdapter,
            mRoomColumnAdapter,
            mRoomAdapter,
            mRoomFooterAdapter,
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        fetchRooms(null, null)

        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker().build()

        fab.setOnClickListener {
            dateRangePicker.show(supportFragmentManager, null)
        }

        dateRangePicker.addOnPositiveButtonClickListener {
            fetchRooms(it.first, it.second?.plus(86_400_000)?.minus(1))
        }

    }

    private fun fetchRooms(begin: Long?, end: Long?) {
        launch {
            progressBar.isVisible = true
            recyclerView.isVisible = false

            val response = TegApi().callFetchRoomHistory(begin, end)

            progressBar.isVisible = false
            recyclerView.isVisible = true

            mDateHeaderAdapter.submitData(Pair(begin, end))
            mRoomColumnAdapter.submitData(Unit)
            mRoomAdapter.submitList(response.roomHistories)
            mRoomFooterAdapter.submitData(response)
        }
    }

}
