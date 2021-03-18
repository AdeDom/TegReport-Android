package com.adedom.tegreport.data

import com.adedom.tegreport.BuildConfig
import com.adedom.tegreport.models.LogActiveResponse
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface MockyApi {

//    @GET("v3/ee0eeb62-c018-4ca1-8ae9-44770e35e51a")
//    suspend fun callFetchPlayer(): PlayerResponse

    @GET("v3/455291f9-1990-4969-b807-85c78a174800")
    suspend fun callFetchLogActive(): LogActiveResponse

//    @GET("v3/112d2604-6123-4c22-b389-16aacba0a45f")
//    suspend fun callFetchFinal(): FinalResponse

    companion object {
        operator fun invoke(): MockyApi {
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
                baseUrl("https://run.mocky.io/")
            }.build()

            return retrofit.create()
        }
    }

}
