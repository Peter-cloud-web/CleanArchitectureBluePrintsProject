package com.seanpeters.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class NetworkModule {
    private val moshi by lazy{
        val moshiBuilder = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
        moshiBuilder.build()
    }

    private val logginInterceptor by lazy {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        loggingInterceptor
    }

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(logginInterceptor)
            .build()
    }

    private fun getRetrofit(endpointURL:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endpointURL)
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    }

    fun createBookApi(endpointURL: String):BooksApi{
        val retrofit = getRetrofit(endpointURL)
            return retrofit.create(BooksApi::class.java)
    }
}