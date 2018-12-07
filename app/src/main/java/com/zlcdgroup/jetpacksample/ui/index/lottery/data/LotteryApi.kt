package com.zlcdgroup.jetpacksample.ui.index.lottery.data

import android.annotation.SuppressLint
import com.zlcdgroup.jetpacksample.net.Http
import com.zlcdgroup.jetpacksample.net.dto.JuHeApiResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.http.GET
import retrofit2.http.Query

interface LotteryApi {
    @GET("lottery/types?key=5f91f48174d0c9a7eb27e44f72fc62fb")
    fun lotteryTypes(): Observable<JuHeApiResponse<List<LotteryType>>>


    @GET("lottery/query?key=5f91f48174d0c9a7eb27e44f72fc62fb")
    fun lotteryQuery(
        @Query("lottery_id") lottery_id: String,
        @Query("lottery_no") lottery_no: String
    ): Observable<JuHeApiResponse<LotteryOpenResult>>


    @GET("lottery/history?key=5f91f48174d0c9a7eb27e44f72fc62fb")
    fun lotteryHistory(
        @Query("lottery_id") lottery_id: String,
        @Query("page_size") page_size: Int,
        @Query("page") page: Int
    ): Observable<JuHeApiResponse<LotteryResList>>

    @GET("lottery/bonus?key=5f91f48174d0c9a7eb27e44f72fc62fb")
    fun lotteryBonus(
        @Query("lottery_id") lottery_id: String,
        @Query("lottery_res") lottery_res: String,
        @Query("lottery_no") lottery_no: String
    ): Observable<JuHeApiResponse<LotteryBonusResult>>

}

@SuppressLint("CheckResult")
object LotteryApiMethod {
    val serverUrl = "http://apis.juhe.cn/"

    fun lotteryTypes(ok: (JuHeApiResponse<List<LotteryType>>) -> Unit, error: (Throwable) -> Unit) {
        Http.createAPI<LotteryApi>(serverUrl).lotteryTypes().subscribeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                ok.invoke(it)
            }, {
                error.invoke(it)
            })
    }

    fun lotteryQuery(
        lottery_id: String,
        lottery_no: String,
        ok: (JuHeApiResponse<LotteryOpenResult>) -> Unit,
        error: (Throwable) -> Unit
    ) {
        Http.createAPI<LotteryApi>(serverUrl).lotteryQuery(lottery_id, lottery_no).subscribeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                ok.invoke(it)
            }, {
                error.invoke(it)
            })
    }

    fun lotteryHistory(
        lottery_id: String,
        page_size: Int,
        page: Int,
        ok: (JuHeApiResponse<LotteryResList>) -> Unit,
        error: (Throwable) -> Unit
    ) {
        Http.createAPI<LotteryApi>(serverUrl).lotteryHistory(lottery_id, page_size, page).subscribeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                ok.invoke(it)
            }, {
                error.invoke(it)
            })
    }

    fun lotteryBonus(
        lottery_id: String,
        lottery_res: String,
        lottery_no: String,
        ok: (JuHeApiResponse<LotteryBonusResult>) -> Unit,
        error: (Throwable) -> Unit
    ) {
        Http.createAPI<LotteryApi>(serverUrl).lotteryBonus(lottery_id, lottery_res, lottery_no)
            .subscribeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                ok.invoke(it)
            }, {
                error.invoke(it)
            })
    }

}