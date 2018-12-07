package com.zlcdgroup.jetpacksample.ui.index.news.data

import android.annotation.SuppressLint
import com.zlcdgroup.jetpacksample.net.Http
import com.zlcdgroup.jetpacksample.net.dto.JuHeApiResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    /**
     * Path是路径中的参数，Query是问号后面的参数
     */
    @GET("toutiao/index?key=9aa6a333c2800500903ca739d83ae688")
    fun toutiao(@Query("type") type: String): Observable<JuHeApiResponse<NewsListResponseResult>>
}

object NewsApiMethod {
    val serverUrl = "http://v.juhe.cn/"
    @SuppressLint("CheckResult")
    fun getNews(newsType: String, ok: (JuHeApiResponse<NewsListResponseResult>) -> Unit, error: (Throwable) -> Unit) {
        Http.createAPI<NewsApi>(serverUrl).toutiao(newsType).subscribeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                ok.invoke(it)
            }, {
                error.invoke(it)
            })
    }
}