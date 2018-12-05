package com.zlcdgroup.jetpacksample.net

import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("toutiao/index?type={type}&key=9aa6a333c2800500903ca739d83ae688")
    fun toutiao(@Path("type") type: String): Observable<NewsListResponse>
}

