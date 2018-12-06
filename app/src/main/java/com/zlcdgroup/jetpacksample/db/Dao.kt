package com.zlcdgroup.jetpacksample.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsData

@Dao
interface NewsDataDao {
    @Query("select * from NewsData where category=:category order by date desc")
    fun getNewsDataList(category: String): LiveData<List<NewsData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(newsDataList: List<NewsData>)
}