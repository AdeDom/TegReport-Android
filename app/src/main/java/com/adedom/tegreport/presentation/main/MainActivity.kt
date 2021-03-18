package com.adedom.tegreport.presentation.main

import android.content.Intent
import android.os.Bundle
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.presentation.itemcollection.ItemCollectionActivity
import com.adedom.tegreport.presentation.logactive.LogActiveActivity
import com.adedom.tegreport.presentation.multicollection.MultiCollectionActivity
import com.adedom.tegreport.presentation.multiitem.MultiItemActivity
import com.adedom.tegreport.presentation.player.PlayerActivity
import com.adedom.tegreport.presentation.room.RoomActivity
import com.adedom.tegreport.presentation.singleitem.SingleItemActivity
import com.adedom.tegreport.presentation.testfinal.FinalActivity
import com.adedom.tegreport.utils.submitList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar?.title = "The Egg Game - Report"
        setSupportActionBar(toolbar)

        val adt = MainAdapter()

        recyclerView.submitList(adt, getReport())

        adt.setOnClickListener {
            val activityClass = when (it.first) {
                1 -> PlayerActivity::class.java
                2 -> LogActiveActivity::class.java
                3 -> RoomActivity::class.java
                4 -> ItemCollectionActivity::class.java
                5 -> MultiCollectionActivity::class.java
                6 -> SingleItemActivity::class.java
                7 -> MultiItemActivity::class.java
                8 -> FinalActivity::class.java
                else -> null
            }

            Intent(baseContext, activityClass).apply {
                putExtra("report", it.second)
                startActivity(this)
            }
        }
    }

    private fun getReport(): List<Pair<Int, String>> {
        return listOf(
            Pair(1, "รายงานการจัดอันดับของผู้เล่นเกม"),
            Pair(2, "รายงานประวัติการเข้าเล่นเกม"),
            Pair(3, "รายงานห้องของผู้เล่นเกมแบบเป็นทีม"),
            Pair(4, "รายงานการเก็บไอเท็มของผู้เล่นเกมทั้งหมด"),
            Pair(5, "รายงานการเก็บไอเท็มของผู้เล่นเกมแบบเป็นทีม"),
            Pair(6, "รายงานไอเท็มที่แสดงของผู้เล่นเกมแบบคนเดียว"),
            Pair(7, "รายงานไอเท็มที่แสดงของผู้เล่นเกมแบบเป็นทีม"),
            Pair(8, "ทดลองออกรายงาน"),
        )
    }

}
