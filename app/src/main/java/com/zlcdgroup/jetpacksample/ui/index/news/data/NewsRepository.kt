package com.zlcdgroup.jetpacksample.ui.index.news.data

import androidx.lifecycle.LiveData
import com.zlcdgroup.jetpacksample.db.AppDatabase

class NewsRepository(val database: AppDatabase) {

    fun getNewsDataList(): LiveData<List<NewsData>> {
        return database.getNewsDataDao().getNewsDataList()
    }
}