package com.zlcdgroup.jetpacksample.net

import com.readystatesoftware.chuck.ChuckInterceptor
import com.zlcdgroup.fastjson.FastJsonConverterFactory
import com.zlcdgroup.jetpacksample.BuildConfig
import com.zlcdgroup.jetpacksample.app.App
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

object Http {
    //设置超时时间，不要设置过长，避免不良体验
    const val timeout = 10L
    private const val serverUrl = "http://v.juhe.cn/"

     fun createAPI(): API {
        val okBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okBuilder.addInterceptor(httpLoggingInterceptor)
            //添加网络查询显示
            okBuilder.addInterceptor(ChuckInterceptor(App.instance))
        }

        okBuilder.connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(8, 5, TimeUnit.MINUTES))
            .retryOnConnectionFailure(false)

        val retrofit = Retrofit.Builder()
            .baseUrl(serverUrl)
            .client(okBuilder.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(FastJsonConverterFactory())
            .build()

        return retrofit.create(API::class.java)
    }
}