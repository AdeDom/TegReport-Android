package com.adedom.tegreport.data

import com.adedom.teg.models.report.*
import com.adedom.teg.util.TegConstant
import com.adedom.tegreport.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface TegApi {

    @GET("api/report/item-collection")
    suspend fun callFetchItemCollection(): ItemCollectionResponse

    @GET("api/report/log-active")
    suspend fun callFetchLogActive(): LogActiveResponse

    @GET("api/report/multi-collection")
    suspend fun callFetchMultiCollection(): MultiCollectionResponse

    @GET("api/report/multi-item")
    suspend fun callFetchMultiItem(): MultiItemResponse

    @GET("api/report/player")
    suspend fun callFetchPlayer(): PlayerResponse

    @GET("api/report/room")
    suspend fun callFetchRoom(): RoomResponse

    @GET("api/report/room-info")
    suspend fun callFetchRoomInfo(): RoomInfoResponse

    @GET("api/report/single-item")
    suspend fun callFetchSingleItem(): SingleItemResponse

    companion object {
        operator fun invoke(): TegApi {
            val okHttpClient = OkHttpClient.Builder().apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }

                connectTimeout(60, TimeUnit.SECONDS)
                writeTimeout(60, TimeUnit.SECONDS)
                readTimeout(60, TimeUnit.SECONDS)

                addNetworkInterceptor(StethoInterceptor())
            }.build()

            val retrofit = Retrofit.Builder().apply {
                client(okHttpClient)
                addConverterFactory(GsonConverterFactory.create())
                baseUrl(TegConstant.BASE_URL)
            }.build()

            return retrofit.create()
        }
    }

}