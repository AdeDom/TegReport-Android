package com.adedom.tegreport.data

import com.adedom.teg.models.report.*
import com.adedom.teg.models.report.five.MultiCollectionHistoryResponse
import com.adedom.teg.models.report.four.ItemCollectionHistoryResponse
import com.adedom.teg.models.report.six.SingleItemHistoryResponse
import com.adedom.teg.models.report.testfinal.FinalResponse
import com.adedom.teg.models.report.three.RoomHistoryResponse
import com.adedom.teg.models.report.two.LogActiveHistoryResponse
import com.adedom.tegreport.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
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

    @GET("api/report/game-player-rankings/level")
    suspend fun callFetchGamePlayerRankings(
        @Query("begin") begin: Int? = 1,
        @Query("end") end: Int? = 99,
    ): GamePlayerRankingsResponse

    @GET("api/report/log-active-history/filter")
    suspend fun callFetchLogActiveHistory(
        @Query("dateTimeIn") dateTimeIn: Long?,
        @Query("dateTimeOut") dateTimeOut: Long?,
    ): LogActiveHistoryResponse

    @GET("api/report/room-history/filter")
    suspend fun callFetchRoomHistory(
        @Query("begin") begin: Long?,
        @Query("end") end: Long?,
    ): RoomHistoryResponse

    @GET("api/report/item-collection-history/filter")
    suspend fun callFetchItemCollectionHistory(
        @Query("begin") begin: Long?,
        @Query("end") end: Long?,
    ): ItemCollectionHistoryResponse

    @GET("api/report/multi-collection-history/filter")
    suspend fun callFetchMultiCollectionHistory(
        @Query("begin") begin: Long?,
        @Query("end") end: Long?,
    ): MultiCollectionHistoryResponse

    @GET("api/report/single-item-history/filter")
    suspend fun callFetchSingleItemHistory(
        @Query("begin") begin: Long?,
        @Query("end") end: Long?,
    ): SingleItemHistoryResponse

    @GET("api/report/test-final/pantip")
    suspend fun callFetchTestFinalPantip(
        @Query("begin") begin: Long?,
        @Query("end") end: Long?,
    ): FinalResponse

    companion object {

        private const val HOST_NAME = ""
        private const val BASE_URL = "http://$HOST_NAME:8080/"

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
                baseUrl(BASE_URL)
            }.build()

            return retrofit.create()
        }
    }

}
