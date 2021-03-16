package com.adedom.tegreport.data

import com.adedom.tegreport.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

// https://run.mocky.io/v3/112d2604-6123-4c22-b389-16aacba0a45f
interface FinalApi {

//    @GET("v3/112d2604-6123-4c22-b389-16aacba0a45f")
//    suspend fun callFetchFinal(): FinalResponse

    companion object {
        operator fun invoke(): FinalApi {
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
