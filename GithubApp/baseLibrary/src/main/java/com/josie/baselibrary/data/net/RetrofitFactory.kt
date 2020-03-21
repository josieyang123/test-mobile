package com.josie.baselibrary.data.net

import com.josie.baselibrary.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.anko.AnkoLogger
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @description : About configuration of Retrofit
 * created by josie at 2020/3/20
 */
class RetrofitFactory private constructor() : AnkoLogger {
    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val interceptor: Interceptor

    init {
        //初始化OkHttp中的头部
        interceptor = Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("charset", "utf-8")
                .build()
            chain.proceed(request)
        }
        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    //初始化OkHttp
    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(initLogInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    //初始化OkHttp中的日志
    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY//只打印body
        return interceptor
    }

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}