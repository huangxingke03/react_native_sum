package com.example.common.net

import com.example.common.content.NetUrl.weather_base_url
import com.example.common.LogUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitManager {
    companion object {
        fun getInstance(): RetrofitManager {
            return RetrofitManager()
        }
    }

    fun <T> getService(service: Class<T>): T {
        return getRetrofit().create(service)
    }

    private fun getOkhttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor { message ->
                LogUtils.d(": $message")
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
            .readTimeout(20 * 1000, TimeUnit.MILLISECONDS).build()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(weather_base_url)
            .client(getOkhttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}