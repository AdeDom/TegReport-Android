package com.adedom.tegreport.presentation

import android.content.Intent
import android.os.Bundle
import com.adedom.tegreport.R
import com.adedom.tegreport.base.BaseActivity
import com.adedom.tegreport.data.TegApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

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

    override fun onStart() {
        super.onStart()

        launch {
            val itemCollectionResponse = async { TegApi().callFetchItemCollection() }
            val logActiveResponse = async { TegApi().callFetchLogActive() }
            val multiCollectionResponse = async { TegApi().callFetchMultiCollection() }
            val multiItemResponse = async { TegApi().callFetchMultiItem() }
            val playerResponse = async { TegApi().callFetchPlayer() }
            val roomResponse = async { TegApi().callFetchRoom() }
            val roomInfoResponse = async { TegApi().callFetchRoomInfo() }
            val singleItemResponse = async { TegApi().callFetchSingleItem() }

            tvItemCollection.text = itemCollectionResponse.await().itemCollections.size.toString()
            tvLogActive.text = logActiveResponse.await().logActives.size.toString()
            tvMultiCollection.text = multiCollectionResponse.await().multiCollections.size.toString()
            tvMultiItem.text = multiItemResponse.await().multiItems.size.toString()
            tvPlayer.text = playerResponse.await().players.size.toString()
            tvRoom.text = roomResponse.await().rooms.size.toString()
            tvRoomInfo.text = roomInfoResponse.await().roomInfoList.size.toString()
            tvSingleItem.text = singleItemResponse.await().singleItems.size.toString()
        }
    }

}
