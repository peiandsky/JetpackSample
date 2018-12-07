package com.zlcdgroup.jetpacksample.net

import com.zlcdgroup.jetpacksample.net.dto.JuHeApiResponse
import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsListResponseResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface API {
    /**
     * Path是路径中的参数，Query是问号后面的参数
     */
    @GET("toutiao/index?key=9aa6a333c2800500903ca739d83ae688")
    fun toutiao(@Query("type") type: String): Observable<JuHeApiResponse<NewsListResponseResult>>
}

