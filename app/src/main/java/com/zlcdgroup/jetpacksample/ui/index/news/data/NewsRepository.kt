package com.zlcdgroup.jetpacksample.ui.index.news.data

import androidx.lifecycle.LiveData
import com.zlcdgroup.jetpacksample.BuildConfig
import com.zlcdgroup.jetpacksample.db.AppDatabase

class NewsRepository(private val database: AppDatabase) {

    fun getNewsDataList(category: String): LiveData<List<NewsData>> {
        if (BuildConfig.DEBUG) {
            println("getNewsDataList:$category")
        }
        return database.getNewsDataDao().getNewsDataList(category)
    }

    fun insertAll(newsDataList: List<NewsData>) {
        database.getNewsDataDao().insertAll(newsDataList)
    }

}