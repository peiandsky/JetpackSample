package com.zlcdgroup.jetpacksample.ui.index.news.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "NewsData")
class NewsData : Serializable {
    constructor()

    @PrimaryKey
    var uniquekey: String = ""
    @ColumnInfo(name = "title")
    var title: String? = null
    @ColumnInfo(name = "date")
    var date: String? = null
    @ColumnInfo(name = "category")
    var category: String? = null
    @ColumnInfo(name = "author_name")
    var author_name: String? = null
    @ColumnInfo(name = "url")
    var url: String? = null
    @ColumnInfo(name = "thumbnail_pic_s")
    var thumbnail_pic_s: String? = null

    @ColumnInfo(name = "thumbnail_pic_s02")
    var thumbnail_pic_s02: String? = null
    
    @ColumnInfo(name = "thumbnail_pic_s03")
    var thumbnail_pic_s03: String? = null
}

class NewsListResponseResult(var stat: String, var data: List<NewsData>?)


class NewsListResponse(var error_code: Int, var reason: String?, var result: NewsListResponseResult?)