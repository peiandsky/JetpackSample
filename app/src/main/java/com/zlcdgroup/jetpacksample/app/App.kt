package com.zlcdgroup.jetpacksample.app

import android.app.Application
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.simple.spiderman.SpiderMan

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        MultiDex.install(this)

        //开发时用来捕捉崩溃异常
        SpiderMan.init(this)
        //开发时查看Sqlite数据库，查看网络访问等
        Stetho.initializeWithDefaults(this)

    }
}